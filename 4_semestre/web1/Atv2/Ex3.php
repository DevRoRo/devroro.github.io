<?php
echo "Números entre 1000 e 2000 onde (número % 11) = 5:\n";

for ($i = 1000; $i <= 2000; $i++) {
    if ($i % 11 == 5) {
        echo $i . "\n";
    }
}
?>