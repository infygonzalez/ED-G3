
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
function tipoEvento(radio) {
    document.getElementById("vuelos").style = (radio.value == "vuelo") ? "display: block" : "display: none";
    tipoVuelo()
    document.getElementById("alojamientos").style = (radio.value == "alojamientoRadio") ? "display: block" : "display: none";
    document.getElementById("otros").style = (radio.value == "otro") ? "display: block" : "display: none";
}
function tipoVuelo() {
    document.getElementById("vuelovuelta").style = (document.getElementById('ida-vuelta').checked == true && document.getElementById('ida').value == "vuelo") ? "display: block" : "display: none";
}
function calcularDias() {
    if(document.getElementById("FechaInicio").value != "" && document.getElementById("FechaFin").value != "" ){
        const date1 = new Date(document.getElementById("FechaInicio").value);
        const date2 = new Date(document.getElementById("FechaFin").value);
        var diffDays = parseInt((date2 - date1) / (1000 * 60 * 60 * 24), 10)+1; 
        if (diffDays > 0) {
            document.getElementById("DuracionViaje").innerHTML = "Duración del viaje: " + diffDays + ((diffDays == 1) ? " día" : " días");
        } else {
            document.getElementById("DuracionViaje").innerHTML = "La FECHA FIN no puede ser antes que la FECHA INICIO"
        }
    }else {
        document.getElementById("DuracionViaje").innerHTML = ""
    }
}