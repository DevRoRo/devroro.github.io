<?php
$numeros = array();

for ($i = 1; $i <= 3; $i++) {
    $numeros[] = (float)readline("Digite o número $i: ");
}

$maior = max($numeros);
$menor = min($numeros);

echo "Maior número: " . $maior . "\n";
echo "Menor número: " . $menor . "\n";
?>