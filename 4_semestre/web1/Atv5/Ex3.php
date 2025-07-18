<?php
$numeros = array();
for ($i = 0; $i < 5; $i++) {
    $numeros[] = rand(1, 100);
}

$media = array_sum($numeros) / count($numeros);

echo "Números gerados: " . implode(", ", $numeros) . "\n";
echo "Média: " . number_format($media, 2) . "\n";
echo "Números maiores que a média:\n";
foreach ($numeros as $numero) {
    if ($numero > $media) {
        echo $numero . "\n";
    }
}
?>