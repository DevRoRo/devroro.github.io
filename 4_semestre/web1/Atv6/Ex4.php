<?php
$soma = 0;
$quantidade = 10;

for ($i = 1; $i <= $quantidade; $i++) {
    $numero = (float)readline("Digite o número $i de $quantidade: ");
    $soma += $numero;
}

$media = $soma / $quantidade;
echo "A média dos números informados é: " . number_format($media, 2) . "\n";
?>