<?php
require_once('php/agencia.php');
require_once('php/conexion.php');

    session_start(); 
    if (isset($_SESSION['Agencia'])) {
      list($nombreAgencia,  $colorAgencia,$logoAgencia) = conseguirAgencia($_SESSION['Agencia'],$conn);
    } else {
      header(header: "location: /login.php");

    }
 ?>
<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title><?php echo  $nombreAgencia; ?></title>

  <link rel="stylesheet" href="css/base.css">
  <link rel="stylesheet" href="css/login.css">

  <style>
    * {
      --coloragencia: <?php echo  $colorAgencia; ?>;
      --coloragenciatexto:   white;
    }
    
  </style>
</head>


<body>
    <main id="principal">
        <div  class="contenedor">
            <h1><a href="#" id="logo"><img src="<?php echo  $logoAgencia; ?>;" alt=""></a></h1>
            <button id="Vuelo">
                Registrar  Vuelo <img id="imagenVuelo" src="img/avion.png" alt="">
            </button>
            <button id="Evento">
                Registrar  Evento <img id="imagenEvento" src="img/cartel-de-hotel.png" alt=""></a> 
            </button>
           
        </div>
    </main>
</body>


</html>