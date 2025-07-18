<?php
$longitudeInicial = -43.2;
$longitudeDestino = -38.5;
$velocidade = 20;

$distanciaTotal = abs($longitudeDestino - $longitudeInicial) * 111;
$direcao = ($longitudeDestino > $longitudeInicial) ? 1 : -1;
$diasViagem = 0;
$distanciaPercorrida = 0;

while (true) {
    $distanciaDia = $velocidade * 24;
    $distanciaRestante = $distanciaTotal - $distanciaPercorrida;
    
    if ($distanciaDia >= $distanciaRestante) {
        $distanciaPercorrida = $distanciaTotal;
        $longitudeAtual = $longitudeDestino;
        echo "Dia " . ++$diasViagem . ": Longitude " . $longitudeAtual . "\n";
        break;
    } else {
        $distanciaPercorrida += $distanciaDia;
        $longitudeAtual = $longitudeInicial + ($direcao * ($distanciaPercorrida / 111));
        echo "Dia " . ++$diasViagem . ": Longitude " . $longitudeAtual . "\n";
    }
}
?>