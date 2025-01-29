<?php
require_once('conexion.php');
$nombreAgencia = "";
$colorAgencia = "";
$logoAgencia = "";
$login = false;
session_start();
if (isset($_SESSION['Agencia'])) {
    $nombreAgencia = $_SESSION['Agencia'];
    $sql = "SELECT * FROM agencia WHERE NombreAgencia = '$nombreAgencia'";
    $resultado = $conn->query($sql);

    if ($resultado->num_rows == 1) {
        $login = true;
        $row = $resultado->fetch_assoc();
        $colorAgencia = $row['ColorMarca'];
        $logoAgencia = $row['Logo'];
    }
}
if ($login == false) {
    header(header: "location: /login.php");
}
?>
  <style>
    * {
      --coloragencia: <?php echo $colorAgencia; ?>;
      --coloragenciatexto: white;
    }
  </style>
