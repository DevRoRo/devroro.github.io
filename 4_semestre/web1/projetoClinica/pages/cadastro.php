<?php
session_start();
require_once '../includes/header.php';
require_once '../includes/auth.php';
?>

<h2>Cadastro</h2>
<?php if (isset($erro)): ?>
    <div class="alert alert-danger"><?= $erro ?></div>
<?php endif; ?>

<form method="post" action="../includes/auth.php">
    <div class="mb-3">
        <label for="nome" class="form-label">Nome</label>
        <input type="text" class="form-control" id="nome" name="nome" required>
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="email" class="form-control" id="email" name="email" required>
    </div>
    <div class="mb-3">
        <label for="senha" class="form-label">Senha</label>
        <input type="password" class="form-control" id="senha" name="senha" required>
    </div>
    <button type="submit" name="cadastro" class="btn btn-primary">Cadastrar</button>
    <a href="login.php" class="btn btn-link">Já tem conta? Faça login</a>
</form>

<?php require_once '../includes/footer.php'; ?>