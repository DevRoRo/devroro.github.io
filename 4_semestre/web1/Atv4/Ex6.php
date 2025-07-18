<?php
$n = 5; // Valor fixo de n
$fatorial = 1;

for ($i = 1; $i <= $n; $i++) {
    $fatorial *= $i;
}

echo $fatorial;
?>