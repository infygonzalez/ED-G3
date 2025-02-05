<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <?php include_once('conexion-php/agencia.php');?>
  <title><?php echo $nombreAgencia; ?></title>

  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
  <link rel="stylesheet" type="text/css" href="css/styles.css">
  <link rel="stylesheet" type="text/css" href="css/reset.css">
</head>

<body>
    <main class="modal">
        <section class="principal">
            <a href="#" id="logoprincipal"><img src="<?php echo $logoAgencia; ?>;" alt=""></a>
            <h2 class="textoagencia"><?php echo $nombreAgencia; ?></h2>
            <a href="viaje.php" id="Vuelo" class="boton">Registrar Viaje<i class="fa-solid fa-plane xl"></i></a>
            <a href="evento.php" id="Evento" class="boton">Registrar Evento <i class="fa-solid fa-square-h xl"></i></a>
            <a id="Desconectar" class="boton desconectar" >Desconectar<i class="fa-solid fa-arrow-right-from-bracket xl"></i></a>
        </section>
    </main>
    <script src="js/validaciones.js"></script>
</body>


</html>