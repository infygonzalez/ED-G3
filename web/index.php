<?php
require_once('conexion-php/agencia.php');
require_once('conexion-php/conexion.php');

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

  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
  <link rel="stylesheet" href="css/reset.css">
  <link rel="stylesheet" href="css/styles.css">

  <style>
    * {
      --coloragencia: <?php echo  $colorAgencia; ?>;
      --coloragenciatexto: white;
    }
    
  </style>
</head>

<body>
    <main id="principal">
        <div  class="principal">
            <a href="#" id="logoprincipal"><img src="<?php echo  $logoAgencia; ?>;" alt=""></a>
            <button id="Vuelo"><p>Registrar  Vuelo</p> <i class="fa-solid fa-plane xl"></i></button>
            <button id="Evento"><p>Registrar  Evento</p> <i class="fa-solid fa-square-h xl"></i></button>
           
        </div>
    </main>
</body>


</html>