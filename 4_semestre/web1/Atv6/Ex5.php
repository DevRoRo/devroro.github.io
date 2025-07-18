<?php
$totalPacientes = (int)readline("Quantos pacientes a clínica atendeu? ");
$contagemIdades = array();

for ($i = 1; $i <= $totalPacientes; $i++) {
    $idade = (int)readline("Idade do paciente $i: ");
    if (!isset($contagemIdades[$idade])) {
        $contagemIdades[$idade] = 0;
    }
    $contagemIdades[$idade]++;
}

foreach ($contagemIdades as $idade => $quantidade) {
    $porcentagem = ($quantidade / $totalPacientes) * 100;
    echo "Idade $idade anos: " . number_format($porcentagem, 2) . "%\n";
}
?>