<?php
$preco = 5.00;
$lucroMaximo = 0;
$precoLucroMaximo = 0;
$ingressosLucroMaximo = 0;

echo "Preço\tIngressos\tLucro\n";

while ($preco >= 1.00) {
    $ingressos = 120 + (($preco - 5.00) / -0.50) * 26;
    $lucro = ($preco * $ingressos) - 200.00;
    
    echo number_format($preco, 2) . "\t" . $ingressos . "\t\t" . number_format($lucro, 2) . "\n";
    
    if ($lucro > $lucroMaximo) {
        $lucroMaximo = $lucro;
        $precoLucroMaximo = $preco;
        $ingressosLucroMaximo = $ingressos;
    }
    
    $preco -= 0.50;
}

echo "\nLucro máximo: " . number_format($lucroMaximo, 2) . "\n";
echo "Preço do ingresso: " . number_format($precoLucroMaximo, 2) . "\n";
echo "Ingressos vendidos: " . $ingressosLucroMaximo . "\n";
?>