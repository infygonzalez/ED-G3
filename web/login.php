<?php

require_once('conexion-php/conexion.php');
$mensajeError = null;
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
        $mensajeError = "Usuario o contraseña incorrectos.";
    }

}
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar sesión</title>

    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/styles.css">

</head>

<body>
    <main id="loginfondo">
        <section id="login" class="login">
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
    </section>
    </main>
    <script type="text/javascript">
    document.addEventListener("DOMContentLoaded", function(event) {
        <?php if(!empty($mensajeError)){ echo'alert("' . $mensajeError . '");';} ?>
    });
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