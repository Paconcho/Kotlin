$(document).ready(function () {

    function mostrarFormulario(idFormulario) {
        $("form").removeClass("activo");
        $(idFormulario).addClass("activo");
        $("#mensaje").hide();
    }

    function mostrarMensaje(texto, tipo) {
        $("#mensaje")
            .removeClass("ok error")
            .addClass(tipo)
            .text(texto)
            .show();
    }

    // Eventos para alternar entre formularios con tus botones
    $("#btnRegistro").click(function () {
        mostrarFormulario("#formRegistro");
    });

    $("#btnLogin").click(function () {
        mostrarFormulario("#formLogin");
    });

    $("#btnRecuperar").click(function () {
        mostrarFormulario("#formRecuperar");
    });
	$("#comunidad").change(function() {
        var comunidadSeleccionada = $(this).val();

        if(comunidadSeleccionada === "") {
            $("#provincia").empty().append('<option value="">Selecciona primero una comunidad</option>');
            return;
        }

        $.post({
            url: "https://www.serinex.net/SEINE/DAMDU1/provincias.php",
            data: {
                comunidad: comunidadSeleccionada
            },
            dataType: "json",
            success: function (respuesta) {
                // Vacía el select
                $("#provincia").empty();

                // Añadimos la opción por defecto limpia
                $("#provincia").append('<option value="">Selecciona una provincia</option>');

                // Rellena el Select con la respuesta del servidor
                $.each(respuesta, function(i, provincia){
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

    $("#formLogin").submit(function (e) {
        e.preventDefault();

        let emailxx = $("#loginEmail").val();
        let passwordxx = $("#loginPassword").val();

        if (emailxx === "" || passwordxx === "") {
            mostrarMensaje("Debes introducir email y contraseña", "error");
            return false;
        }

        $.ajax({
            url: "https://www.serinex.net/SEINE/DAMDU1/login.php",
            type: "POST",
            data: {
                email: emailxx,
                password: passwordxx
            },
            dataType: "json", // Para que procese el JSON automáticamente como en tu Imagen 3
            success: function (respuesta) {
                if (respuesta.estado == "ok") {
                    mostrarMensaje(respuesta.mensaje, "ok");
                } else {
                    mostrarMensaje(respuesta.mensaje, "error");
                }
            },
            error: function () {
                mostrarMensaje("Error al conectar con el servidor", "error");
            }
        });
    });


    $("#formRegistro").submit(function (e) {
        e.preventDefault();

        let nombrexx = $("#regNombre").val();
        let emailxx = $("#regEmail").val();
        let passwordxx = $("#regPassword").val();

        if (nombrexx === "" || emailxx === "" || passwordxx === "") {
            mostrarMensaje("Debes rellenar todos los campos", "error");
            return false;
        }

        $.post("https://www.serinex.net/SEINE/DAMDU1/registro.php", {
            nombre: nombrexx,
            email: emailxx,
            password: passwordxx
        }, function (respuesta) {
            if (respuesta.estado == "ok") {
                mostrarMensaje(respuesta.mensaje, "ok");
            } else {
                mostrarMensaje(respuesta.mensaje, "error");
            }
        }, "json");
            });


    $("#formRecuperar").submit(function (e) {
        e.preventDefault();

        let emailxx = $("#recEmail").val();

        if (emailxx === "") {
            mostrarMensaje("Debes introducir el email", "error");
            return false;
        }

        $.get("https://www.serinex.net/SEINE/DAMDU1/recuperar.php", {
            email: emailxx
        }, function (respuesta) {
            if (respuesta.estado == "ok") {
                mostrarMensaje(respuesta.mensaje, "ok");
            } else {
                mostrarMensaje(respuesta.mensaje, "error");
            }
        }, "json");
            });

});