<?php
function conseguirAgencia($nombreAgencia, $conn)
{
    $sql = "SELECT * FROM agencia WHERE NombreAgencia = '$nombreAgencia'";
    $resultado = $conn->query($sql);

    if ($resultado->num_rows == 1) {
        $nombreAgencia = "";
        $colorAgencia = "";
        $logoAgencia = "";

        foreach ($resultado as $row) {
            $nombreAgencia = $row['NombreAgencia'];
            $colorAgencia = $row['ColorMarca'];
            $logoAgencia = $row['Logo'];
        }
        return array($nombreAgencia, $colorAgencia, $logoAgencia);

    } else {
        echo "Se ha producido un error: " . $nombreAgencia->error . $sql;
    }

}

?>