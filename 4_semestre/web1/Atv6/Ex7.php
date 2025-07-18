<?php
$numero = (int)readline("Digite um número: ");
$divisivel = false;

if ($numero % 10 == 0) {
    echo "Divisível por 10\n";
    $divisivel = true;
}
if ($numero % 5 == 0) {
    echo "Divisível por 5\n";
    $divisivel = true;
}
if ($numero % 2 == 0) {
    echo "Divisível por 2\n";
    $divisivel = true;
}
if (!$divisivel) {
    echo "Não é divisível por 10, 5 ou 2\n";
}
?>