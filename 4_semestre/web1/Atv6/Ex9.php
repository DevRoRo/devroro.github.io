<?php
// Processamento dos dados
$area = $perimetro = null;
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $lado1 = (float)$_POST['lado1'];
    $lado2 = (float)$_POST['lado2'];
    
    $area = $lado1 * $lado2;
    $perimetro = 2 * ($lado1 + $lado2);
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Cálculo de Retângulo</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 500px;
            margin: 20px auto;
            padding: 20px;
        }
        .container {
            border: 1px solid #ddd;
            padding: 20px;
            border-radius: 5px;
        }
        .resultado {
            margin-top: 20px;
            padding: 10px;
            background-color: #f0f0f0;
            border-radius: 3px;
        }
        input[type="number"] {
            padding: 8px;
            width: 100%;
            box-sizing: border-box;
            margin-bottom: 10px;
        }
        input[type="submit"] {
            padding: 8px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Calculadora de Retângulo</h2>
        <form method="post">
            <label for="lado1">Lado 1:</label>
            <input type="number" step="any" id="lado1" name="lado1" required>
            
            <label for="lado2">Lado 2:</label>
            <input type="number" step="any" id="lado2" name="lado2" required>
            
            <input type="submit" value="Calcular">
        </form>

        <?php if ($_SERVER['REQUEST_METHOD'] === 'POST'): ?>
            <div class="resultado">
                <h3>Resultados:</h3>
                <p>Área: <?= number_format($area, 2) ?></p>
                <p>Perímetro: <?= number_format($perimetro, 2) ?></p>
            </div>
        <?php endif; ?>
    </div>
</body>
</html>