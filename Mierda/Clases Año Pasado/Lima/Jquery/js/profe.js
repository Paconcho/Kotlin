$(document).ready(function () {

    // --- FUNCIONES EXTRAÍDAS DE TUS CAPTURAS DE PANTALLA ---

    function mostrarFormulario(idFormulario) {
        $("form").hide();           // Oculta todos los formularios de golpe
        $(idFormulario).show();     // Muestra el seleccionado nativamente
        $("#mensaje").hide();       // Oculta mensajes previos
    }

    function mostrarMensaje(texto, tipo) {
        $("#mensaje")
            .removeClass("ok error")
            .addClass(tipo)
            .text(texto)
            .show();
    }


    // --- LÓGICA PARA INTERCAMBIAR PANTALLAS ---
    $(".toggle-form").click(function (e) {
        e.preventDefault(); 
        
        let targetId = $(this).data("target"); 
        mostrarFormulario("#" + targetId);
    });


    // --- ENVIOS AJAX DE FORMULARIOS ---

    // 1. Registro
    $("#form-registro").submit(function (e) {
        e.preventDefault(); 

        let nombrexx = $("#reg-nombre").val().trim();
        let emailxx = $("#reg-email").val().trim();
        let passwordxx = $("#reg-pass").val().trim();

        if (nombrexx === "" || emailxx === "" || passwordxx === "") {
            mostrarMensaje("Debes introducir nombre, email y contraseña", "error");
            return false;
        }

        $.ajax({
            url: "https://www.serinex.net/SEINE/DAMDU1/registro.php",
            type: "POST",
            dataType: "json",
            data: {
                nombre: nombrexx,
                email: emailxx,
                password: passwordxx
            },
            success: function (respuesta) {
                if (respuesta.estado == "ok") {
                    mostrarMensaje(respuesta.mensaje, "ok");
                    $("#form-registro")[0].reset(); 
                } else {
                    mostrarMensaje(respuesta.mensaje, "error");
                }
            },
            error: function () {
                mostrarMensaje("Error al conectar con el servidor de registro", "error");
            }
        });
    });

    // 2. Login
    $("#form-login").submit(function (e) {
        e.preventDefault();

        let emailxx = $("#login-email").val().trim();
        let passwordxx = $("#login-pass").val().trim();

        if (emailxx === "" || passwordxx === "") {
            mostrarMensaje("Debes introducir email y contraseña", "error");
            return false;
        }

        $.post("https://www.serinex.net/SEINE/DAMDU1/login.php", {
            email: emailxx,
            password: passwordxx
        }, function (respuesta) {
            if (respuesta.estado == "ok") {
                mostrarMensaje(respuesta.mensaje, "ok");
                $("#form-login")[0].reset();
            } else {
                mostrarMensaje(respuesta.mensaje, "error");
            }
        }, "json"); 
    });

    // 3. Recuperar contraseña
    $("#form-recuperar").submit(function (e) {
        e.preventDefault();

        let emailxx = $("#rec-email").val().trim();

        if (emailxx === "") {
            mostrarMensaje("Debes introducir un correo electrónico", "error");
            return false;
        }

        $.post("https://www.serinex.net/SEINE/DAMDU1/recuperar.php", {
            email: emailxx
        }, function (respuesta) {
            if (respuesta.estado == "ok") {
                mostrarMensaje(respuesta.mensaje, "ok");
                $("#form-recuperar")[0].reset();
            } else {
                mostrarMensaje(respuesta.mensaje, "error");
            }
        }, "json");
    });


    // --- LÓGICA DE PROVINCIAS (CAPTURA 3) ---
    $("#comunidad").change(function() {
        
        var comunidadSeleccionada = $(this).val();

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
                // vacía el select
                $("#provincia").empty();

                // Rellena el Select con la concatenación exacta de tu captura
                $.each(respuesta, function(i, provincia) {
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