
for (var i = 0; i < document.querySelectorAll(".desconectar").length; i++) {
    document.getElementsByClassName("desconectar")[i].pushEventListener('click', desconectar, false);
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
function validarViaje() {
    let NombreViaje = document.forms["RegistrarViaje"]["NombreViaje"].value;
    let TipoViaje = document.forms["RegistrarViaje"]["TipoViaje"].value;
    let Pais = document.forms["RegistrarViaje"]["pais"].value;
    let FechaInicio = document.forms["RegistrarViaje"]["FechaInicio"].value;
    let FechaFin = document.forms["RegistrarViaje"]["FechaFin"].value;
    let Descripcion = document.forms["RegistrarViaje"]["DescripcionViaje"].value;
    let ServiciosNoIncluidos = document.forms["RegistrarViaje"]["ServiciosNoIncluidos"].value;

     mensajeError = [];
    if ((NombreViaje.length >= 1 || NombreViaje.length >= 30) == false) {
        mensajeError.push("Nombre no puede estar vacio");
    }
    if (TipoViaje.length == 0) {
        mensajeError.push("Tipo de viaje no puede estar vacio");
    }
    if (Pais.length == 0) {
        mensajeError.push("Pais no puede estar vacio");
    }
    if (FechaInicio.length == 0) {
        mensajeError.push("Fecha de inicio no puede estar vacio");
    }
    if (FechaFin.length == 0) {
        mensajeError.push("Fecha de fin no puede estar vacio");
    }
    if (FechaFin.length != 0 && FechaInicio.length != 0  &&((new Date(FechaInicio)<new Date(FechaFin) || new Date(FechaInicio)== new Date(FechaFin)) == false)) {
        mensajeError.push("Fecha fin no puede ser antes que fecha inicio");
    }
    if (Descripcion.length == 0) {
        mensajeError.push("Descripción no puede estar vacio");

    }
    if (ServiciosNoIncluidos.length == 0) {
        mensajeError.push("Servicios no incluidos no puede estar vacio");
    }
    if (mensajeError.length != 0) {
      alert("- " + mensajeError.join("\n - "))
        
    }
    return mensajeError.length ==0;
}