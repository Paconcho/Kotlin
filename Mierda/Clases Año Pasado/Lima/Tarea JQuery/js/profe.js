$(document).ready(function () {

    // --- FUNCIONES EXTRAÍDAS DE TUS CAPTURAS DE PANTALLA ---

    // Cambia el formulario activo y oculta los mensajes previos
    function mostrarFormulario(idFormulario) {
        $("form").removeClass("activo");
        $(idFormulario).addClass("activo");
        $("#mensaje").hide();
    }

    // Gestiona dinámicamente el cuadro de feedback con estilos ok/error
    function mostrarMensaje(texto, tipo) {
        $("#mensaje")
            .removeClass("ok error")
            .addClass(tipo)
            .text(texto)
            .show();
    }


    // --- EVENTOS PARA INTERCAMBIAR FORMULARIOS ---

    $("#btnRegistro").click(function () {
        mostrarFormulario("#formRegistro");
    });

    $("#btnLogin").click(function () {
        mostrarFormulario("#formLogin");
    });

    $("#btnRecuperar").click(function () {
        mostrarFormulario("#formRecuperar");
    });


    // --- MANEJO Y ENVÍO DE FORMULARIOS MEDIANTE AJAX ---

    // 1. Envío de Formulario de Registro
    $("#formRegistro").submit(function (e) {
        e.preventDefault(); // Evita la recarga de página

        let nombrexx = $("#regNombre").val().trim();
        let emailxx = $("#regEmail").val().trim();
        let passwordxx = $("#regPassword").val().trim();

        // Validación de campos vacíos
        if (nombrexx === "" || emailxx === "" || passwordxx === "") {
            mostrarMensaje("Debes introducir nombre, email y contraseña", "error");
            return false;
        }

        // Petición AJAX (Estructura $.ajax)
        $.ajax({
            url: "https://www.serinex.net/SEINE/DAMDU1/registro.php",
            type: "POST",
            dataType: "json", // Indicamos explícitamente que procese JSON
            data: {
                nombre: nombrexx,
                email: emailxx,
                password: passwordxx
            },
            success: function (respuesta) {
                if (respuesta.estado == "ok") {
                    mostrarMensaje(respuesta.mensaje, "ok");
                    $("#formRegistro")[0].reset(); // Resetea campos si todo sale bien
                } else {
                    mostrarMensaje(respuesta.mensaje, "error");
                }
            },
            error: function () {
                mostrarMensaje("Error al conectar con el servidor de registro", "error");
            }
        });
    });


    // 2. Envío de Formulario de Login
    $("#formLogin").submit(function (e) {
        e.preventDefault();

        let emailxx = $("#loginEmail").val().trim();
        let passwordxx = $("#loginPassword").val().trim();

        // Validación de campos vacíos (Tal y como se ve en tu captura 2)
        if (emailxx === "" || passwordxx === "") {
            mostrarMensaje("Debes introducir email y contraseña", "error");
            return false;
        }

        // Petición AJAX por POST abreviada (Mapeada de tus capturas)
        $.post("https://www.serinex.net/SEINE/DAMDU1/login.php", {
            email: emailxx,
            password: passwordxx
        }, function (respuesta) {
            // Evaluamos la estructura JSON solicitada
            if (respuesta.estado == "ok") {
                mostrarMensaje(respuesta.mensaje, "ok");
                $("#formLogin")[0].reset();
            } else {
                mostrarMensaje(respuesta.mensaje, "error");
            }
        }, "json"); 
    });


    // 3. Envío de Formulario de Recuperación
    $("#formRecuperar").submit(function (e) {
        e.preventDefault();

        let emailxx = $("#recEmail").val().trim();

        // Validación de campos vacíos
        if (emailxx === "") {
            mostrarMensaje("Debes introducir un correo electrónico", "error");
            return false;
        }

        // Petición AJAX para recuperación
        $.post("https://www.serinex.net/SEINE/DAMDU1/recuperar.php", {
            email: emailxx
        }, function (respuesta) {
            if (respuesta.estado == "ok") {
                mostrarMensaje(respuesta.mensaje, "ok");
                $("#formRecuperar")[0].reset();
            } else {
                mostrarMensaje(respuesta.mensaje, "error");
            }
        }, "json");
    });

    // --- LOGICA DE CARGA DINÁMICA DE PROVINCIAS (CAPTURA 3) ---

$("#comunidad").change(function() {
    
    // var comunidadSeleccionada = $("#comunidad").val();
    var comunidadSeleccionada = $(this).val();

    // Si el usuario vuelve a poner la opción por defecto vacía, limpiamos las provincias
    if (comunidadSeleccionada === "") {
        $("#provincia").empty().append('<option value="">Selecciona una provincia</option>');
        return;
    }

    $.post({
        url: "https://www.serinex.net/SEINE/DAMDU1/provincias.php",
        data: {
            comunidad: comunidadSeleccionada
        },
        dataType: "json",
        success: function (respuesta) {
            //vacía el select
            $("#provincia").empty();

            //Opcional
            /*$("#provincia").append(
                '<option value="">Selecciona una provincia</option>'
            );*/

            //Rellena el Select
            $.each(respuesta, function(i, provincia) {
                $("#provincia").append(
                    '<option value="' + provincia + '">' + provincia + '</option>'
                );
            });
        },
        error: function() {
            alert("Error al cargar las provincias");
        }
    });

});

$("#provincia").change(function(){

    var provinciadSeleccionada = $(this).val();

    $.post({
        url: "https://www.serinex.net/SEINE/DAMDU1/provincias.php",
        data:{
            provincia: provinciadSeleccionada
        },
        dataType: "json",
        success: function (respuesta) {
            //vacía el select
            $("#provincia").empty();

            //Opcional
            /*$("#provincia").append(
                '<option value="">Selecciona una provincia</option>'
            );*/

            //Rellena el Select
            $.each(respuesta, function(i, provincia){
                $("#provincia").append(
                    '<option value=""' + provincia + '">' + provincia + '</option>'
                );
            });
        },
        error: function() {
            alert("Error al cargar las provincias");
        }
    });

});

});