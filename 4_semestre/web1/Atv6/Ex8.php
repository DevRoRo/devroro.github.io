<?php
$num1 = (float)readline("Digite o primeiro número: ");
$num2 = (float)readline("Digite o segundo número: ");
$num3 = (float)readline("Digite o terceiro número: ");

$numeros = [$num1, $num2, $num3];

rsort($numeros);

echo "Números em ordem decrescente: " . implode(", ", $numeros) . "\n";
?>