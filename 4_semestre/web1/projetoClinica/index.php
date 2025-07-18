<?php
session_start();
require_once 'includes/header.php';
?>

<div class="jumbotron text-center">
    <h1 class="display-4">Bem-vindo ao VetAgenda</h1>
    <p class="lead">Sistema de agendamento de consultas veterinárias</p>
    <hr class="my-4">
    <?php if (isset($_SESSION['usuario_id'])): ?>
        <a class="btn btn-primary btn-lg" href="pages/dashboard.php" role="button">Acessar Dashboard</a>
    <?php else: ?>
        <a class="btn btn-primary btn-lg" href="pages/login.php" role="button">Login</a>
        <a class="btn btn-secondary btn-lg" href="pages/cadastro.php" role="button">Cadastre-se</a>
    <?php endif; ?>
</div>

<?php
require_once 'includes/footer.php';
?>