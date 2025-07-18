<?php
$idade = (int)readline("Digite sua idade: ");

if ($idade < 13) {
    echo "Criança\n";
} elseif ($idade >= 13 && $idade <= 19) {
    echo "Adolescente\n";
} elseif ($idade >= 20 && $idade <= 60) {
    echo "Adulto\n";
} else {
    echo "Idoso\n";
}
?>