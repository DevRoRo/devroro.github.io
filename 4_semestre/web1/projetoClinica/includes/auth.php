<?php
// Adicione no início do arquivo (antes de qualquer verificação)
function fazerLogout() {
    // Destrói todas as variáveis de sessão
    $_SESSION = array();
    
    // Se desejar destruir a sessão completamente, apague também o cookie
    if (ini_get("session.use_cookies")) {
        $params = session_get_cookie_params();
        setcookie(
            session_name(),
            '',
            time() - 42000,
            $params["path"],
            $params["domain"],
            $params["secure"],
            $params["httponly"]
        );
    }
    
    // Destrói a sessão
    session_destroy();
    
    // Redireciona para a página de login
    header("Location: login.php");
    exit;
}

// Verifique se foi solicitado logout
if (isset($_GET['logout'])) {
    fazerLogout();
}
session_start();
require_once __DIR__ . '/../config/database.php';

function login($email, $senha) {
    global $pdo;
    
    $stmt = $pdo->prepare("SELECT * FROM usuarios WHERE email = ?");
    $stmt->execute([$email]);
    $usuario = $stmt->fetch();
    
    if ($usuario && password_verify($senha, $usuario['senha'])) {
        $_SESSION['usuario_id'] = $usuario['id'];
        $_SESSION['usuario_nome'] = $usuario['nome'];
        return true;
    }
    return false;
}

function verificarAutenticacao() {
    if (!isset($_SESSION['usuario_id'])) {
        header('Location: /projetoClinica/pages/login.php');
        exit;
    }
}

function logout() {
    session_destroy();
    header('Location: /projetoClinica/pages/login.php');
    exit;
}
?>