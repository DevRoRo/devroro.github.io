<?php
$valorCarro = 100000;

$precoAVista = $valorCarro * 0.80;
echo "À vista: R$ " . number_format($precoAVista, 2, ',', '.') . "\n\n";

echo "Parcelado:\n";
echo "Parcelas | Preço Final | Valor Parcela\n";
echo "--------------------------------------\n";

$parcelas = [6, 12, 18, 24, 30, 36, 42, 48, 54, 60];
$percentuais = [3, 6, 9, 12, 15, 18, 21, 24, 27, 30];

for ($i = 0; $i < count($parcelas); $i++) {
    $precoFinal = $valorCarro * (1 + $percentuais[$i]/100);
    $valorParcela = $precoFinal / $parcelas[$i];
    
    echo str_pad($parcelas[$i], 8) . " | " . 
         str_pad("R$ " . number_format($precoFinal, 2, ',', '.'), 11) . " | " . 
         "R$ " . number_format($valorParcela, 2, ',', '.') . "\n";
}
?>