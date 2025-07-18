<?php
session_start();
require_once '../includes/header.php';
require_once '../config/database.php';

if (!isset($_SESSION['usuario_id'])) {
    header('Location: ../pages/login.php');
    exit;
}

// Consultas do usuário
$stmt = $pdo->prepare("SELECT * FROM consultas WHERE id_usuario = ? ORDER BY data_consulta, hora_consulta");
$stmt->execute([$_SESSION['usuario_id']]);
$consultas = $stmt->fetchAll();
?>

<h2>Bem-vindo, <?= htmlspecialchars($_SESSION['usuario_nome']) ?></h2>
<h3 class="mt-4">Suas Consultas</h3>

<table class="table">
    <thead>
        <tr>
            <th>Data</th>
            <th>Hora</th>
            <th>Idade Animal</th>
            <th>Motivo</th>
            <th>Ações</th>
        </tr>
    </thead>
    <tbody>
        <?php foreach ($consultas as $consulta): ?>
        <tr>
            <td><?= date('d/m/Y', strtotime($consulta['data_consulta'])) ?></td>
            <td><?= substr($consulta['hora_consulta'], 0, 5) ?></td>
            <td><?= $consulta['idade_animal'] ?> anos</td>
            <td><?= htmlspecialchars($consulta['motivo']) ?></td>
            <td>
                <a href="editar_consulta.php?id=<?= $consulta['id'] ?>" class="btn btn-sm btn-warning">Editar</a>
                <a href="#" onclick="confirmarExclusao(<?= $consulta['id'] ?>)" class="btn btn-sm btn-danger">Excluir</a>
            </td>
        </tr>
        <?php endforeach; ?>
    </tbody>
</table>

<a href="nova_consulta.php" class="btn btn-primary">Nova Consulta</a>

<script>
function confirmarExclusao(id) {
    if (confirm('Tem certeza que deseja cancelar esta consulta?')) {
        window.location.href = '../includes/excluir_consulta.php?id=' + id;
    }
}
</script>

<?php require_once '../includes/footer.php'; ?>