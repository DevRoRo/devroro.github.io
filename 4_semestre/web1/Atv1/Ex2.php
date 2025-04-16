<?php

$age = 25;

if ($age < 0) {
    $category = "Idade inválida";
} elseif ($age <= 13) {
    $category = "Criança";
} elseif ($age <= 19) {
    $category = "Adolescente";
} elseif ($age <= 60) {
    $category = "Adulto";
} else {
    $category = "Idoso";
}

echo "Idade: $age ";
echo "Categoria: $category";
?>