<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <?php include_once('conexion-php/agencia.php'); ?>
    <title>Registrar Evento | <?php echo $nombreAgencia; ?></title>
    <link rel="stylesheet" type="text/css"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <script src="js/validaciones.js"></script>
</head>

<body id="top">
    <header>
        <a href="/" id="logo"><img src="<?php echo $logoAgencia; ?>;" alt=""></a>
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
                    <input type="radio" id="vuelo" name="evento" value="vuelo">
                    <label for="vuelo">Vuelo</label>

                    <input type="radio" id="alojamiento" name="evento" value="alojamiento">
                    <label for="alojamiento">Alojamiento</label>

                    <input type="radio" id="otro" name="evento" value="otro">
                    <label for="otro">Otros</label>
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
                        <label for="aeropuertoOrigen">Aeropuerto de Origen</label>
                        <input type="text" list="origen" name="aeropuertoOrigen" required>
                        <datalist id="aeropuertoOrigen">
                            <option>Opcion1</option>
                            <option>Opcion2</option>
                            <option>Opcion3</option>
                    </fieldset>

                    <fieldset>
                        <label for="aeropuertoDestino">Aeropuerto de destino</label>
                        <input type="text" list="aeropuertoDestino" name="aeropuertoDestino" required>
                        <datalist id="aeropuertoDestino">
                            <option>Opcion1</option>
                            <option>Opcion2</option>
                            <option>Opcion3</option>
                    </fieldset>

                    <fieldset>
                        <label for="codigoVuelo">Codigo de Vuelo</label>
                        <input type="text" id="codigoVuelo" name="codigoVuelo" required>
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
                        <label for="fechaSalida">Fecha de Salida</label>
                        <input type="date" id="fechaSalida" name="fechaSalida" required>
                    </fieldset>

                    <fieldset>
                        <label for="HoraSalida">Hora de Salida</label>
                        <input type="time" id="HoraSalida" name="HoraSalida" required>
                    </fieldset>

                    <fieldset>
                        <label for="PrecioVuelo">Precios (€)</label>
                        <input type="number" id="PrecioVuelo" name="PrecioVuelo" step="0.01" required>
                    </fieldset>

                    <fieldset>
                        <label for="DuracionVuelo">Duración del Viaje (Horas)</label>
                        <input type="number" id="DuracionVuelo" name="DuracionVuelo" required>
                    </fieldset>
                </div>

            </section>

            <section id="vuelovuelta">
                <h2>Vuelo de Vuelta</h2>

                <div class="campos">
                    <fieldset>
                        <label for="aeropuertoOrigenVuelta">Codigo de Vuelo</label>
                        <input type="text" id="aeropuertoOrigenVuelta" name="aeropuertoOrigenVuelta" required>
                    </fieldset>

                    <fieldset>
                        <label for="aerolineaVuelta">Aerolinea</label>
                        <input type="text" list="aerolineaVuelta" name="aerolineaVuelta" required>
                        <datalist id="aerolineaVuelta">
                            <option>Opcion1</option>
                            <option>Opcion2</option>
                            <option>Opcion3</option>
                    </fieldset>

                    <fieldset>
                        <label for="fechaSalidaVuelta">Fecha de Salida</label>
                        <input type="date" id="fechaSalidaVuelta" name="fechaSalidaVuelta" required>
                    </fieldset>

                    <fieldset>
                        <label for="horaSalidaVuelta">Hora de Salida</label>
                        <input type="time" id="horaSalidaVuelta" name="horaSalidaVuelta" required>
                    </fieldset>

                    <fieldset>
                        <label for="DuracionVueloVuelta">Duración del Viaje (Horas)</label>
                        <input type="number" id="DuracionVueloVuelta" name="DuracionVueloVuelta" required>
                    </fieldset>
                </div>

            </section>

            <section id="alojamientos">
                <h2>Alojamientos</h2>

                <div class="campos">
                    <fieldset>
                        <label for="FechaEntrada"> Fecha de entrada</label>
                        <input type="date" id="FechaEntrada" name="FechaEntrada" required>
                    </fieldset>
                    <fieldset>
                        <label for="FechaSalida">Fecha de salida</label>
                        <input type="date" id="FechaSalida" name="FechaSalida" required>
                    </fieldset>
                </div>

                <fieldset>
                    <label for="Ciudad">Ciudad</label>
                    <input type="text" id="Ciudad" name="Ciudad" required>
                </fieldset>

                <fieldset>
                    <label for="NombreHotel">Nombre del Hotel</label>
                    <input type="text" id="NombreHotel" name="NombreHotel" required>
                </fieldset>

                <div class="campos">
                    <fieldset>
                        <label for="PrecioAlojamiento">Precios (€)</label>
                        <input type="number" id="PrecioAlojamiento" name="PrecioAlojamiento" step="0.01" required>
                    </fieldset>

                    <fieldset>
                        <label for="TipoHabitacion">Tipo de Habitación</label>
                        <input type="text" list="TipoHabitacion" name="TipoHabitacion" required>
                        <datalist id="TipoHabitacion">
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
                        <label for="FechaOtros">Fecha</label>
                        <input type="date" id="FechaOtros" name="FechaOtros" required>
                    </fieldset>

                    <fieldset>
                        <label for="PrecioOtros">Precios (€)</label>
                        <input type="number" id="PrecioOtros" name="PrecioOtros" step="0.01" required>
                    </fieldset>
                </div>

                <fieldset>
                    <label for="Descripcion">Descripción</label>
                    <textarea maxlength="500" name="Descripción" placeholder="Max. 500 palabras"></textarea>
                </fieldset>


            </section>
            <button type="submit" class="botonformulario">Guardar servicio</button>
        </form>

    </main>

    <footer>
        <nav>
            <ul>
                <li><a href="#">© <?php echo $nombreAgencia; ?></a></li>
                <li><a onclick="return desconectar()" class="desconectar"><i
                            class="fa-solid fa-arrow-right-from-bracket"></i>Desconectar</a></li>
                <li><a href="#top"><i class="fa-solid fa-arrow-up"></i>Subir</a></li>
            </ul>
        </nav>
    </footer>
</body>

</html>