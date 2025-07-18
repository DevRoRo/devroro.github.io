<?php
$resultado = '';
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $v1 = (float)$_POST['v1'];
    $v2 = (float)$_POST['v2'];
    $operacao = $_POST['operacao'];

    switch ($operacao) {
        case 'soma':
            $resultado = $v1 + $v2;
            break;
        case 'subtracao':
            $resultado = $v1 - $v2;
            break;
        case 'multiplicacao':
            $resultado = $v1 * $v2;
            break;
        case 'divisao':
            $resultado = ($v2 != 0) ? $v1 / $v2 : "Erro: divisão por zero";
            break;
        case 'potenciacao':
            $resultado = pow($v1, $v2);
            break;
        default:
            $resultado = "Operação inválida";
    }
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Calculadora PHP</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
        }
        .calculator {
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .result {
            margin-top: 20px;
            padding: 10px;
            background-color: #e9e9e9;
            border-radius: 3px;
        }
    </style>
</head>
<body>
    <div class="calculator">
        <h2>Calculadora</h2>
        <form method="post">
            <div>
                <label for="v1">Valor 1:</label>
                <input type="number" step="any" id="v1" name="v1" required>
            </div>
            <div>
                <label for="v2">Valor 2:</label>
                <input type="number" step="any" id="v2" name="v2" required>
            </div>
            <div>
                <label for="operacao">Operação:</label>
                <select id="operacao" name="operacao" required>
                    <option value="soma">Soma (+)</option>
                    <option value="subtracao">Subtração (-)</option>
                    <option value="multiplicacao">Multiplicação (*)</option>
                    <option value="divisao">Divisão (/)</option>
                    <option value="potenciacao">Potenciação (^)</option>
                </select>
            </div>
            <div>
                <button type="submit">Calcular</button>
            </div>
        </form>

        <?php if ($_SERVER['REQUEST_METHOD'] === 'POST'): ?>
            <div class="result">
                <h3>Resultado:</h3>
                <p><?php echo htmlspecialchars($resultado); ?></p>
            </div>
        <?php endif; ?>
    </div>
</body>
</html>