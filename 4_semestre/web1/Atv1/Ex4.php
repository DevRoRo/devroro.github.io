<?php
$loan = 10000;
$months = 12;
$salary = 5000;

$payment = $loan / $months;
$maxPayment = $salary * 0.3;

if ($payment <= $maxPayment) {
    echo "Aprovado! Parcela de R$: " . number_format($payment, 2) . " Durante $months meses.";
} else {
    echo "Reprovado! Parcela de: (R$" . number_format($payment, 2) . ") é muito alta.";
}
?>