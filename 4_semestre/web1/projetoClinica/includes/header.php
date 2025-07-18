<?php
require_once __DIR__ . '/auth.php';
?>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VetAgenda</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container">
            <a class="navbar-brand" href="../index.php">VetAgenda</a>
            <div class="navbar-nav">
                <?php if(isset($_SESSION['usuario_id'])): ?>
                    <a class="nav-link" href="pages/dashboard.php">Dashboard</a>
                    <a class="nav-link" href="nova_consulta.php">Nova Consulta</a>
                    <a class="nav-link" href="?logout=1">Sair</a>
                <?php else: ?>
                    <a class="nav-link" href="login.php">Login</a>
                    <a class="nav-link" href="cadastro.php">Cadastre-se</a>
                <?php endif; ?>
            </div>
        </div>
    </nav>
    <div class="container mt-4">