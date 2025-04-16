<?php
$n = rand(1, 20);

function fatorial($num) {
    return ($num <= 1) ? 1 : $num * fatorial($num - 1);
}

echo "Número aleatório (n): $n\n";
echo "$n! = " . number_format(fatorial($n), 0, ',', '.') . "\n";
?>