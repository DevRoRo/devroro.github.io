<?php
$temperature = 150;

if ($temperature >= 0 && $temperature <= 300) {
    $status = "Normal";
} elseif ($temperature == -50 || $temperature == 500) {
    $status = "Crítico";
} else {
    $status = "estado de Alerta";
}

echo "Temperatura do tanque: " . $temperature . "°C ";
echo "Status: " . $status;
?>