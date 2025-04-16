<?php

$grade1 = 7.5; 
$grade2 = 6.0;
$grade3 = 5.5;

$mean = ($grade1 + $grade2 + $grade3) / 3;

echo "A média aritmética é: " . number_format($mean, 2) . "<br>";

if ($mean >= 6) {
    echo "Status: Aprovado";
} else {
    echo "Status: Reprovado";
}
?>