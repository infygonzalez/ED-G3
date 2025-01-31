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

<body id="top">
  <header>
    <a href="#" id="logo"><img src="<?php echo $logoAgencia; ?>;" alt=""></a>
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
 
        <form action="#" method="get" id="RegistrarViaje">
            <div class="campos">
            <fieldset>
                <label for="NombreViaje">Nombre del viaje</label>
                <input type="text" name="NombreViaje" required placeholder="Escriba el nombre del viaje">
            </fieldset>
            <fieldset>
                <label for="TipoViaje">Tipo de viaje</label>
                <input type="text" list="TipoViaje">
                <datalist id="TipoViaje">
                    <option>Novios</option>
                    <option>Senior</option>
                    <option>Grupos</option>
                    <option>Grandes viajes(destinos exoticos)</option>
                    <option>Combinado(vuelo+hotel)</option>
                    <option>Escapadas</option>
                    <option>Familias con niños menores</option>
            </fieldset>
            </div>  
            <div class="campos">
            <fieldset>
                <label for="FechaInicio">Fecha de inicio</label>
                <input type="date" name="FechaInicio">
            </fieldset>
            <fieldset>
                <label for="FechaFin">Fecha de fin</label>
                <input type="date" name="FechaFin">
            </fieldset>
            </div>  
            <fieldset>
                <label for="DuracionViaje"></label>
            </fieldset>
            <fieldset>
                <label for="DescripcionViaje">Descripción</label>
                <textarea maxlength="500" name="DescripcionViaje"  placeholder="Max. 500 palabras"></textarea>
            </fieldset>
            <fieldset>
                <label for="ServiciosNoIncluidos">Servicios no incluidos</label>
                <textarea maxlength="500" name="ServiciosNoIncluidos"  placeholder="Max. 500 palabras"></textarea>
            </fieldset>

            <br>
            <button type="submit">Guardar viaje</button>
        </form>

  </main>

  <footer>
    <nav>
      <ul>
        <li><a href="#"><i class="fa-solid fa-copyright"></i>Copyright</a></li>
        <li><a onclick="return desconectar()"><i class="fa-solid fa-arrow-right-from-bracket"></i>Desconectar</a></li>
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