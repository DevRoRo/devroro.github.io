<?php
require_once '../config/database.php';
session_start();

if (!isset($_SESSION['usuario_id']) || !isset($_GET['id'])) {
    header('Location: ../pages/login.php');
    exit;
}

$id_consulta = $_GET['id'];

// Verificar se a consulta pertence ao usuário
$stmt = $pdo->prepare("SELECT id FROM consultas WHERE id = ? AND id_usuario = ?");
$stmt->execute([$id_consulta, $_SESSION['usuario_id']]);
$consulta = $stmt->fetch();

if ($consulta) {
    try {
        $stmt = $pdo->prepare("DELETE FROM consultas WHERE id = ?");
        $stmt->execute([$id_consulta]);
        $_SESSION['sucesso'] = "Consulta cancelada com sucesso!";
    } catch (PDOException $e) {
        $_SESSION['erro'] = "Erro ao cancelar consulta: " . $e->getMessage();
    }
} else {
    $_SESSION['erro'] = "Consulta não encontrada ou não pertence a você.";
}

header('Location: ../pages/dashboard.php');
exit;
?>