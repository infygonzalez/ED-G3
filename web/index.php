<?php
require_once('php/agencia.php');
require_once('php/conexion.php');

    session_start(); 
    if (isset($_SESSION['Agencia'])) {
      list($nombreAgencia,  $colorAgencia,$logoAgencia) = conseguirAgencia($_SESSION['Agencia'],$conn);
    } else {
      // Redirigir al login si no hay una sesion detectada
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
        <li><a href="#">Registrar Vuelo</a></li>
        <li><a href="#">Registrar Evento</a></li>
      </ul>
    </nav>
  </header>

  <main>

  </main>

  <footer>
    <nav>
      <ul>
        <li><a href="#">Copyright</a></li>
        <li><a onclick="return desconectar()">Desconectar</a></li>
        <li><a href="#top">▲</a></li>
      </ul>
    </nav>
  </footer>
  <script type="text/javascript">
        function desconectar() {
          document.cookie =  'PHPSESSID=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
          window.location.href = "/login.php";
        }
    </script>
</body>

</html>