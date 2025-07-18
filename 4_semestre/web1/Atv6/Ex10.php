<?php
$imc = $mensagem = '';
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $peso = (float)$_POST['peso'];
    $altura = (float)$_POST['altura'];
    $imc = $peso / ($altura * $altura);
    $mensagem = ($imc > 25) ? "Você está acima do peso!" : "Você está saudável!";
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Calculadora de IMC</title>
    <style>
        body { font-family: Arial, sans-serif; max-width: 400px; margin: 0 auto; padding: 20px; }
        .container { border: 1px solid #ddd; padding: 20px; border-radius: 5px; }
        .resultado { margin-top: 20px; padding: 10px; background-color: #f0f0f0; border-radius: 3px; }
        input { padding: 8px; width: 100%; box-sizing: border-box; margin-bottom: 10px; }
        button { padding: 8px 15px; background-color: #4CAF50; color: white; border: none; cursor: pointer; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Calculadora de IMC</h2>
        <form method="post">
            <label for="peso">Peso (kg):</label>
            <input type="number" step="0.1" id="peso" name="peso" required>
            
            <label for="altura">Altura (m):</label>
            <input type="number" step="0.01" id="altura" name="altura" required>
            
            <button type="submit">Calcular IMC</button>
        </form>

        <?php if ($_SERVER['REQUEST_METHOD'] === 'POST'): ?>
            <div class="resultado">
                <p>Seu IMC: <?= number_format($imc, 2) ?></p>
                <p><?= $mensagem ?></p>
            </div>
        <?php endif; ?>
    </div>
</body>
</html>