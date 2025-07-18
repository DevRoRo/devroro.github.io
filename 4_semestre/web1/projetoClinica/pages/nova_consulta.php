<?php
session_start();
require_once '../includes/header.php';
require_once '../includes/auth.php';
require_once '../config/database.php';

verificarAutenticacao();

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $erros = [];
    
    if (empty($_POST['idade_animal'])) {
        $erros[] = "Idade do animal é obrigatória";
    } elseif (!is_numeric($_POST['idade_animal']) || $_POST['idade_animal'] <= 0) {
        $erros[] = "Idade do animal deve ser um número positivo";
    }

    if (empty($_POST['data_consulta'])) {
        $erros[] = "Data da consulta é obrigatória";
    } else {
        $dataConsulta = new DateTime($_POST['data_consulta']);
        $dataAtual = new DateTime();
        
        if ($dataConsulta < $dataAtual) {
            $erros[] = "A data da consulta deve ser futura";
        }
        
        $diaSemana = $dataConsulta->format('w');
        if ($diaSemana == 0 || $diaSemana == 6) {
            $erros[] = "Não são permitidos agendamentos em finais de semana";
        }
    }

    if (empty($_POST['hora_consulta'])) {
        $erros[] = "Hora da consulta é obrigatória";
    } else {
        $hora = (int) substr($_POST['hora_consulta'], 0, 2);
        if ($hora < 8 || $hora > 18) {
            $erros[] = "O horário deve ser entre 08:00 e 18:00";
        }
    }

    if (empty($_POST['motivo']) || strlen($_POST['motivo']) < 10) {
        $erros[] = "O motivo deve ter pelo menos 10 caracteres";
    }

    if (empty($erros)) {
        try {
            $stmt = $pdo->prepare(
                "INSERT INTO consultas 
                (id_usuario, idade_animal, data_consulta, hora_consulta, motivo) 
                VALUES (?, ?, ?, ?, ?)"
            );
            
            $result = $stmt->execute([
                $_SESSION['usuario_id'],
                $_POST['idade_animal'],
                $_POST['data_consulta'],
                $_POST['hora_consulta'],
                $_POST['motivo']
            ]);
            
            if ($result) {
                $_SESSION['sucesso'] = "Consulta agendada com sucesso!";
                header('Location: dashboard.php');
                exit;
            }
        } catch (PDOException $e) {
            $erro = "Erro ao agendar consulta. Tente novamente mais tarde.";
        }
    }
}
?>

<h2>Nova Consulta</h2>

<?php if (!empty($erros)): ?>
    <div class="alert alert-danger">
        <?php foreach ($erros as $erro): ?>
            <p><?= htmlspecialchars($erro) ?></p>
        <?php endforeach; ?>
    </div>
<?php endif; ?>

<?php if (isset($erro)): ?>
    <div class="alert alert-danger"><?= htmlspecialchars($erro) ?></div>
<?php endif; ?>

<!-- FORMULÁRIO HTML AQUI -->
<form method="post" action="nova_consulta.php">
    <div class="mb-3">
        <label for="idade_animal" class="form-label">Idade do Animal</label>
        <input type="number" class="form-control" id="idade_animal" name="idade_animal" min="1" max="30" required>
    </div>
    
    <div class="mb-3">
        <label for="data_consulta" class="form-label">Data da Consulta</label>
        <input type="date" class="form-control" id="data_consulta" name="data_consulta" 
               min="<?= date('Y-m-d', strtotime('+1 day')) ?>" required>
    </div>
    
    <div class="mb-3">
        <label for="hora_consulta" class="form-label">Hora da Consulta</label>
        <input type="time" class="form-control" id="hora_consulta" name="hora_consulta" 
               min="08:00" max="18:00" required>
    </div>
    
    <div class="mb-3">
        <label for="motivo" class="form-label">Motivo</label>
        <textarea class="form-control" id="motivo" name="motivo" rows="3" 
                  placeholder="Descreva detalhadamente o motivo da consulta" required></textarea>
    </div>
    
    <button type="submit" class="btn btn-primary">Agendar Consulta</button>
    <a href="dashboard.php" class="btn btn-secondary">Cancelar</a>
</form>

<?php require_once '../includes/footer.php'; ?>