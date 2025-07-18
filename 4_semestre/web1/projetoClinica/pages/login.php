<?php
session_start();
require_once '../includes/header.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    require_once '../includes/auth.php';
    
    if (login($_POST['email'], $_POST['senha'])) {
        header('Location: dashboard.php');
        exit;
    } else {
        $erro = "Email ou senha incorretos";
    }
}
?>

<div class="row justify-content-center">
    <div class="col-md-6">
        <h2>Login</h2>
        
        <?php if (isset($erro)): ?>
            <div class="alert alert-danger"><?= htmlspecialchars($erro) ?></div>
        <?php endif; ?>
        
        <form method="post">
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="mb-3">
                <label for="senha" class="form-label">Senha</label>
                <input type="password" class="form-control" id="senha" name="senha" required>
            </div>
            <button type="submit" class="btn btn-primary">Entrar</button>
            <a href="cadastro.php" class="btn btn-link">Não tem conta? Cadastre-se</a>
        </form>
    </div>
</div>

<?php require_once '../includes/footer.php'; ?>