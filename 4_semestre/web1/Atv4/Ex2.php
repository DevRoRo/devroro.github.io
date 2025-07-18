<?php
$n = 9;
$soma = 0;

for ($i = 1; $i <= $n; $i++) {
    $soma += 1 / $i;
}

echo "S = " . $soma;
?>