<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <?php
  include_once('conexion-php/agencia.php');
  ?>
  <title><?php echo $nombreAgencia; ?></title>

  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
  <link rel="stylesheet" type="text/css" href="css/styles.css">
  <link rel="stylesheet" type="text/css" href="css/reset.css">
  
</head>

<body>
    <main id="principal">
        <div  class="principal">
            <a href="#" id="logoprincipal"><img src="<?php echo $logoAgencia; ?>;" alt=""></a>
            <button id="Vuelo"><p>Registrar  Vuelo</p> <i class="fa-solid fa-plane xl"></i></button>
            <button id="Evento"><p>Registrar  Evento</p> <i class="fa-solid fa-square-h xl"></i></button>
           
        </div>
    </main>
</body>


</html>