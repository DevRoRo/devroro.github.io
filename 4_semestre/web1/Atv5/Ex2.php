<?php
$notas = array();
$notas[] = 9;
$notas[] = 5;
$notas[] = 7;

$soma = array_sum($notas);
$media = $soma / count($notas);

$status = ($media >= 6) ? "Aprovado" : "Reprovado";

echo "N1 = " . $notas[0] . " | N2 = " . $notas[1] . " | N3 = " . $notas[2];
echo " | MG = " . number_format($media, 2) . " [$status]";
?>