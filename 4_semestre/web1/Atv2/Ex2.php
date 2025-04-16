<?php
// Verifica se o valor foi enviado por GET ou POST
if ($_SERVER['REQUEST_METHOD'] === 'POST' || isset($_GET['n'])) {
    $n = $_REQUEST['n'] ?? null;
    
    // Valida o valor de entrada
    if ($n !== null && is_numeric($n) && $n > 0) {
        $n = (float)$n;
        $soma = 0.0;
        
        // Calcula a soma da série harmônica
        for ($i = 1; $i <= $n; $i++) {
            $soma += 1 / $i;
        }
        
        // Exibe o resultado formatado
        echo "A soma da série 1 + 1/2 + 1/3 + ... + 1/$n é: " . number_format($soma, 6, ',', '.');
    } else {
        echo "Por favor, digite um número positivo válido para 'n'.";
    }
} else {
    // Mostra um formulário se nenhum valor foi enviado
    echo '
    <form method="post">
        Digite um número positivo (n): <input type="number" step="any" name="n" min="0.000001" required>
        <input type="submit" value="Calcular">
    </form>
    ';
}
?>