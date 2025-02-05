
for (var i = 0; i < document.querySelectorAll(".desconectar").length; i++) {
    document.getElementsByClassName("desconectar")[i].addEventListener('click', desconectar, false);
}
function desconectar() {
    document.cookie = 'PHPSESSID=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
    window.location.href = "/login.php";
}

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