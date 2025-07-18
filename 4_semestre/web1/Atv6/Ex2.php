<?php
$acertos = 0;

$n1 = (float)readline("Digite o primeiro número: ");
$n2 = (float)readline("Digite o segundo número: ");

$resposta_soma = (float)readline("Quanto é $n1 + $n2? ");
$resposta_sub = (float)readline("Quanto é $n1 - $n2? ");
$resposta_mult = (float)readline("Quanto é $n1 * $n2? ");
$resposta_div = (float)readline("Quanto é $n1 / $n2? ");

// Verificar respostas
if ($resposta_soma == ($n1 + $n2)) $acertos++;
if ($resposta_sub == ($n1 - $n2)) $acertos++;
if ($resposta_mult == ($n1 * $n2)) $acertos++;

// Tratamento especial para divisão (evitar divisão por zero e comparar com margem de erro para decimais)
if ($n2 != 0) {
    if (abs($resposta_div - ($n1 / $n2)) < 0.0001) $acertos++;
} elseif ($resposta_div == "infinito" || $resposta_div == "erro") {
    $acertos++;
}

echo "\nVocê acertou $acertos de 4 perguntas!\n";

// Mostrar respostas corretas
echo "\nRespostas corretas:\n";
echo "$n1 + $n2 = " . ($n1 + $n2) . "\n";
echo "$n1 - $n2 = " . ($n1 - $n2) . "\n";
echo "$n1 * $n2 = " . ($n1 * $n2) . "\n";
if ($n2 != 0) {
    echo "$n1 / $n2 = " . ($n1 / $n2) . "\n";
} else {
    echo "$n1 / $n2 = indefinido (divisão por zero)\n";
}
?>