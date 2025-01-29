<?php

require_once('php/conexion.php');

if (isset($_POST['login'])) {

    $usuario = $_POST['usuario'];
    $contrasena = $_POST['contrasena'];

    $sql = "SELECT * FROM agencia WHERE NombreAgencia = '$usuario' and Contraseña = '$contrasena'";
    $resultado = $conn->query($sql);

    if ($resultado->num_rows == 1) {
        session_start();
        $_SESSION['Agencia'] = $usuario;
        header(header: "location: /");

    } else {
        echo "Se ha producido un error: " . $conn->error . $sql;
    }

}
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar sesión</title>

    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/login.css">

</head>

<body>
    <main id="loginfondo">
        <div id="login" class="contenedor">
            <h1>Iniciar sesión</h1>
            <form name="login" action="<?php echo $_SERVER['PHP_SELF']; ?>" onsubmit="return validarLogin()"
                method="post">
                <fieldset>
                    <label for="usuario">Usuario</label>
                    <input type="text" name="usuario">
                </fieldset>
                <fieldset>
                    <label for="contrasena">Contraseña</label>
                    <input type="password" name="contrasena">
                </fieldset>
                <button type="submit" name="login">Iniciar sesión</button>
            </form>
        </div>
    </main>
    <script>
        function validarLogin() {
            let usuario = document.forms["login"]["usuario"].value;
            if (usuario == "") {
                alert("El campo usuario no puede estar vacío");
                return false;
            }
            let contrasena = document.forms["login"]["contrasena"].value;
            if (contrasena == "") {
                alert("El campo contraseña no puede estar vacío");
                return false;
            }
            return true;
        }
    </script>
</body>

</html>