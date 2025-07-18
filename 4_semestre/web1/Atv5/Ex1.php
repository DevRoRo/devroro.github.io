<?php
$vetor = array(12, 5, 8, 19, 3, 7, 14, 21, 6, 9, 11, 4, 17, 2, 10, 15, 1, 13, 16, 20);

$maior = $vetor[0];
$menor = $vetor[0];
$soma = 0;
$pares = 0;

foreach ($vetor as $numero) {
    if ($numero > $maior) {
        $maior = $numero;
    }
    if ($numero < $menor) {
        $menor = $numero;
    }
    $soma += $numero;
    if ($numero % 2 == 0) {
        $pares++;
    }
}

$media = $soma / count($vetor);
$percentualPares = ($pares / count($vetor)) * 100;

echo "Maior elemento: " . $maior . "\n";
echo "Menor elemento: " . $menor . "\n";
echo "Percentual de pares: " . number_format($percentualPares, 2) . "%\n";
echo "Média dos elementos: " . number_format($media, 2) . "\n";
?>