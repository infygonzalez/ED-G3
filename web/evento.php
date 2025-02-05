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
        <a href="/" id="logo"><img src="<?php echo $logoAgencia ?>" alt=""></a>
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
        <form action="<?php echo $_SERVER['PHP_SELF']; ?>" onsubmit="return validarEvento()"
        method="post" id="RegistrarEvento" >
            <section id="evento">
                <h1>Registrar Evento</h1>
                <fieldset>
                    <label for="viajeID">Elegir Viaje</label>
                    <select id="viajeID" >
                        <option></option>
                        <?php include('conexion-php/viajes.php'); ?>
                    </select>
                </fieldset>
                <fieldset>
                    <label for="vuelo-ida">Nombre del Evento</label>
                    <input type="text" id="nombre-evento" name="servicio" >
                </fieldset>
                <fieldset class="inline">
                    <legend>Tipo de Evento</legend>
                    <input type="radio" id="vuelo" name="tipoEventoRadio" onclick="tipoEvento(this)" value="vuelo">
                    <label for="vuelo">Vuelo</label>

                    <input type="radio" id="alojamientoRadio" name="tipoEventoRadio" onclick="tipoEvento(this)"
                        value="alojamientoRadio">
                    <label for="alojamientoRadio">Alojamiento</label>

                    <input type="radio" id="otro" name="tipoEventoRadio" onclick="tipoEvento(this)" value="otro">
                    <label for="otro">Otros</label>
                </fieldset>

            </section>

            <section id="vuelos">
                <h2>Vuelo de ida</h2>

                <fieldset class="inline">
                    <legend>Que tipo de vuelo es?</legend>
                    <input type="radio" id="ida" name="tipoVueloRadio" onclick="tipoVuelo()" value="ida" checked>
                    <label for="ida">Ida</label>
                    <input type="radio" id="ida-vuelta" name="tipoVueloRadio" onclick="tipoVuelo()" value="ida-vuelta">
                    <label for="ida-vuelta">Ida/Vuelta</label>
                </fieldset>

                <div class="campos">
                    <fieldset>
                        <label for="aeropuertoOrigen">Aeropuerto de Origen</label>
                        <select id="aeropuertoOrigen" >
                            <option></option>
                            <?php include('conexion-php/aeropuerto.php'); ?>
                        </select>
                    </fieldset>

                    <fieldset>
                        <label for="aeropuertoDestino">Aeropuerto de destino</label>
                        <select id="aeropuertoDestino" >
                            <option></option>
                            <?php include('conexion-php/aeropuerto.php'); ?>
                        </select>
                    </fieldset>

                    <fieldset>
                        <label for="codigoVuelo">Codigo de Vuelo</label>
                        <input type="text" id="codigoVuelo" name="codigoVuelo" >
                    </fieldset>

                    <fieldset>
                        <label for="aerolinea">Aerolinea</label>
                        <select id="aerolinea" >
                            <option></option>
                            <?php include('conexion-php/aerolinea.php'); ?>
                        </select>
                    </fieldset>

                    <fieldset>
                        <label for="fechaSalida">Fecha de Salida</label>
                        <input type="date" id="fechaSalida" name="fechaSalida" >
                    </fieldset>

                    <fieldset>
                        <label for="HoraSalida">Hora de Salida</label>
                        <input type="time" id="HoraSalida" name="HoraSalida" >
                    </fieldset>

                    <fieldset>
                        <label for="PrecioVuelo">Precio</label>
                        <div class="precio">
                            <input type="number" id="PrecioVuelo" name="PrecioVuelo" step="0.1" >
                            <span>€</span>
                        </div>
                    </fieldset>

                    <fieldset>
                        <label for="DuracionVuelo">Duración del Viaje (Horas)</label>
                        <input type="number" id="DuracionVuelo" name="DuracionVuelo" >
                    </fieldset>
                </div>

            </section>

            <section id="vuelovuelta">
                <h2>Vuelo de Vuelta</h2>

                <div class="campos">
                    <fieldset>
                        <label for="codigoVueloVuelta">Codigo de Vuelo</label>
                        <input type="text" id="codigoVueloVuelta" name="codigoVueloVuelta" >
                    </fieldset>

                    <fieldset>
                        <label for="aerolineaVuelta">Aerolinea</label>
                        <select id="aerolineaVuelta" >
                            <option></option>
                            <?php include('conexion-php/aerolinea.php'); ?>
                        </select>
                    </fieldset>

                    <fieldset>
                        <label for="fechaSalidaVuelta">Fecha de Salida</label>
                        <input type="date" id="fechaSalidaVuelta" name="fechaSalidaVuelta" >
                    </fieldset>

                    <fieldset>
                        <label for="horaSalidaVuelta">Hora de Salida</label>
                        <input type="time" id="horaSalidaVuelta" name="horaSalidaVuelta" >
                    </fieldset>

                    <fieldset>
                        <label for="DuracionVueloVuelta">Duración del Viaje (Horas)</label>
                        <input type="number" id="DuracionVueloVuelta" name="DuracionVueloVuelta" >
                    </fieldset>
                </div>

            </section>

            <section id="alojamientos">
                <h2>Alojamientos</h2>

                <div class="campos">
                    <fieldset>
                        <label for="FechaEntrada"> Fecha de entrada</label>
                        <input type="date" id="FechaEntrada" name="FechaEntrada" >
                    </fieldset>
                    <fieldset>
                        <label for="FechaSalida">Fecha de salida</label>
                        <input type="date" id="FechaSalida" name="FechaSalida" >
                    </fieldset>
                </div>

                <fieldset>
                    <label for="Ciudad">Ciudad</label>
                    <input type="text" id="Ciudad" name="Ciudad" >
                </fieldset>

                <fieldset>
                    <label for="NombreHotel">Nombre del Hotel</label>
                    <input type="text" id="NombreHotel" name="NombreHotel" >
                </fieldset>

                <div class="campos">
                    <fieldset>
                        <label for="PrecioAlojamiento">Precio</label>
                        <div class="precio">
                            <input type="number" id="PrecioAlojamiento" name="PrecioAlojamiento" step="0.1" >
                            <span>€</span>
                        </div>
                    </fieldset>

                    <fieldset>
                        <label for="TipoHabitacion">Tipo de Habitación</label>
                        <select id="TipoHabitacion" >
                            <option></option>
                            <option value="DB">Doble</option>
                            <option value="DUI">Doble con uso individual</option>        
                            <option value="SIN">Individual</option>                   
                            <option value="TPL">Triple</option>                   
                         </select>

                    </fieldset>
                </div>

            </section>

            <section id="otros">
                <h2>Otros Servicios</h2>

                <div class="campos">
                    <fieldset>
                        <label for="FechaOtros">Fecha</label>
                        <input type="date" id="FechaOtros" name="FechaOtros" >
                    </fieldset>

                    <fieldset>
                        <label for="PrecioOtros">Precio</label>
                        <div class="precio">
                            <input type="number" id="PrecioOtros" name="PrecioOtros" step="0.1" >
                            <span>€</span>
                        </div>
                    </fieldset>
                </div>

                <fieldset>
                    <label for="Descripción">Descripción</label>
                    <textarea maxlength="500" name="Descripción" placeholder="Max. 500 palabras"></textarea>
                </fieldset>


            </section>
            <button type="submit" class="botonformulario">Guardar evento</button>
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