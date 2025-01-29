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
  <link rel="stylesheet" href="css/styles.css">
  <link rel="stylesheet" href="css/reset.css">
  <style>
    * {
      --coloragencia: <?php echo  $colorAgencia; ?>;
      --coloragenciatexto:   white;
    }
  </style>
</head>

<body id="top">
  <header>
    <a href="#" id="logo"><img src="<?php echo  $logoAgencia; ?>;" alt=""></a>
    <nav>
      <label for="ico">☰</label>
      <input id="ico" type="checkbox">
      <ul>
        <li><a href="#"><i class="fa-sharp fa-solid fa-plane"></i>Registrar Vuelo</a></li>
        <li><a href="#"><i class="fa-regular fa-calendar-days"></i>Registrar Evento</a></li>
      </ul>
    </nav>
  </header>

  <main>

  </main>

  <footer>
    <nav>
      <ul>
        <li><a href="#"><i class="fa-solid fa-copyright"></i>Copyright</a></li>
        <li><a href="#"><i class="fa-solid fa-arrow-right-from-bracket"></i>Desconectar</a></li>
        <li><a href="#top">▲</a></li>
      </ul>
    </nav>
  </footer>
</body>

</html>