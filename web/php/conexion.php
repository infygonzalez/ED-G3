<?php

// Parámetros de conexión a la BD
$servidor = "127.0.0.1:33060";
$usuario = "root";
$pass = "elorrieta";
$bd = "viajeserrekamari";

// Conexión
$conn = new mysqli($servidor, $usuario, $pass, $bd);

// Comprobación de que se ha realizado la conexión
if ($conn->connect_error) {
    die("Fallo en la conexión: " . $conn->connect_error);
}

// Aquí trabajaremos con la base de datos
// ...
// ...
// ...

// Y cerraremos la conexión al final


?>