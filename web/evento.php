<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <?php include_once('conexion-php/agencia.php'); ?>
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
        <li><a href="viaje.php"><i class="fa-sharp fa-solid fa-plane"></i>Registrar Viaje</a></li>
        <li><a href="evento.php"><i class="fa-regular fa-calendar-days"></i>Registrar Evento</a></li>
      </ul>
    </nav>
  </header>

  <main>
  <form>
        <section id="evento">
            <h1>Registrar Evento</h1>
            <h2>Nuevo Evento</h2>
            
                <fieldset>
                    <label for="vuelo-ida">Elegir Viaje</label>
                    <input type="text" id="vuelo-ida" name="servicio" required>
                </fieldset>
                <fieldset>
                    <label for="vuelo-ida">Nombre del Evento</label>
                    <input type="text" id="nombre-evento" name="servicio" required>
                </fieldset>
                <fieldset class="inline">
                    <legend>Tipo de Evento</legend>
                    <input type="radio" id="vuelos0" name="evento" value="vuelos0">
                    <label for="vuelos0">Vuelo</label>

                    <input type="radio" id="alojamiento" name="evento" value="alojamiento">
                    <label for="alojamiento">Alojamiento</label>

                    <input type="radio" id="otros" name="evento" value="otros">
                    <label for="otros">Otros</label>
                </fieldset>
            
        </section>

        <section id="vuelos">
            <h2>Nuevo Vuelo</h2>
            
                <fieldset class="inline">
                    <legend>Que tipo de vuelo es?</legend>
                    <input type="radio" id="ida" name="servicio" value="ida" checked>
                    <label for="ida">Ida</label>
                    <input type="radio" id="ida-vuelta" name="servicio" value="ida-vuelta">
                    <label for="ida-vuelta">Ida/Vuelta</label>
                </fieldset>

                <div class="campos">
                    <fieldset>
                        <label for="origen">Aeropuerto de Origen</label>
                        <input type="text" list="origen" name="origen" required>
                        <datalist id="origen">
                            <option>Opcion1</option>
                            <option>Opcion2</option>
                            <option>Opcion3</option>
                    </fieldset>

                    <fieldset>
                        <label for="llegada">Aeropuerto de Llegada</label>
                        <input type="text" list="llegada" name="llegada" required>
                        <datalist id="llegada">
                            <option>Opcion1</option>
                            <option>Opcion2</option>
                            <option>Opcion3</option>
                    </fieldset>

                    <fieldset>
                        <label for="codigo-vuelo">Codigo de Vuelo</label>
                        <input type="text" id="codigo-vuelo" name="codigo-vuelo" required>
                    </fieldset>

                    <fieldset>
                        <label for="aerolinea">Aerolinea</label>
                        <input type="text" list="aerolinea" name="aerolinea" required>
                        <datalist id="aerolinea">
                            <option>Opcion1</option>
                            <option>Opcion2</option>
                            <option>Opcion3</option>
                    </fieldset>

                    <fieldset>
                        <label for="fecha-salida">Fecha de Salida</label>
                        <input type="date" id="fecha-salida" name="fecha-salida" required>
                    </fieldset>

                    <fieldset>
                        <label for="hora-salida">Hora de Salida</label>
                        <input type="time" id="hora-salida" name="hora-salida" required>
                    </fieldset>

                    <fieldset>
                        <label for="precio">Precios (€)</label>
                        <input type="number" id="precio" name="precio" step="0.01" required>
                    </fieldset>

                    <fieldset>
                        <label for="duracion">Duración del Viaje (Horas)</label>
                        <input type="number" id="duracion" name="duracion" required>
                    </fieldset>
                </div>
            
        </section>

        <section id="vuelovuelta">
            <h2>Vuelo de Vuelta</h2>
            
                <div class="campos">
                    <fieldset>
                        <label for="origen">Codigo de Vuelo</label>
                        <input type="text" id="origen" name="origen" required>
                    </fieldset>

                    <fieldset>
                        <label for="aerolinea2">Aerolinea</label>
                        <input type="text" list="aerolinea2" name="aerolinea2" required>
                        <datalist id="aerolinea2">
                            <option>Opcion1</option>
                            <option>Opcion2</option>
                            <option>Opcion3</option>
                    </fieldset>

                    <fieldset>
                        <label for="fecha-salida2">Fecha de Salida</label>
                        <input type="date" id="fecha-salida2" name="fecha-salida2" required>
                    </fieldset>

                    <fieldset>
                        <label for="hora-salida2">Hora de Salida</label>
                        <input type="time" id="hora-salida2" name="hora-salida2" required>
                    </fieldset>

                    <fieldset>
                        <label for="precio2">Precios (€)</label>
                        <input type="number" id="precio2" name="precio" step="0.01" required>
                    </fieldset>

                    <fieldset>
                        <label for="duracion2">Duración del Viaje (Horas)</label>
                        <input type="number" id="duracion" name="duracion2" required>
                    </fieldset>
                </div>
            
        </section>

        <section id="alojamientos">
            <h2>Alojamientos</h2>
            
                <div class="campos">
                    <fieldset>
                        <label for="vuelo-ida">Entrada</label>
                        <input type="date" id="vuelo-ida" name="vuelo-ida" required>
                    </fieldset>
                    <fieldset>
                        <label for="salida">Salida</label>
                        <input type="date" id="salida" name="salida" required>
                    </fieldset>
                </div>

                <fieldset>
                    <label for="llegada">Ciudad</label>
                    <input type="text" id="llegada" name="llegada" required>
                </fieldset>

                <fieldset>
                    <label for="codigo-vuelo">Nombre del Hotel</label>
                    <input type="text" id="codigo-vuelo" name="codigo-vuelo" required>
                </fieldset>

                <div class="campos">
                    <fieldset>
                        <label for="precio3">Precios (€)</label>
                        <input type="number" id="precio3" name="precio3" step="0.01" required>
                    </fieldset>

                    <fieldset>
                        <label for="tipo-habitacion">Tipo de Habitación</label>
                        <input type="text" list="tipo-habitacion" name="tipo-habitacion" required>
                        <datalist id="tipo-habitacion">
                            <option>Opcion1</option>
                            <option>Opcion2</option>
                            <option>Opcion3</option>
                    </fieldset>
                </div>
                            
        </section>

        <section class="otros">
            <h2>Otros Servicios</h2>
           
                <div class="campos">
                    <fieldset>
                        <label for="fecha-otros">Fecha</label>
                        <input type="date" id="fecha-otros" name="fecha-otros" required>
                    </fieldset>

                    <fieldset>
                        <label for="precio4">Precios (€)</label>
                        <input type="number" id="precio4" name="precio4" step="0.01" required>
                    </fieldset>
                </div>

                <fieldset>
                <label for="descripcion">Descripción</label>
                <textarea maxlength="500" name="Descripción" placeholder="Max. 500 palabras"></textarea>
            </fieldset>

          
        </section>
        <button type="submit">Guardar servicio</button>
</form>

    </main>

  <footer>
    <nav>
      <ul>
        <li><a href="#"><i class="fa-solid fa-copyright"></i>Copyright</a></li>
        <li><a onclick="return desconectar()"><i class="fa-solid fa-arrow-right-from-bracket"></i>Desconectar</a></li>
        <li><a href="#top"><i class="fa-solid fa-arrow-up"></i>Subir</a></li>
      </ul>
    </nav>
  </footer>
</body>

</html>