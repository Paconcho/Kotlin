$(document).ready(function() {
    const URL_BASE = "https://www.serinex.net/SEINE/DAMDU1/";

    $('.toggle-form').click(function(e) {
        e.preventDefault();
        const target = $(this).data('target');
        $('form').hide();
        $('#mensaje').hide();
        
        $('#' + target).fadeIn();
    });

    function enviarFormulario(url, datos, formId) {
        $.ajax({
            url: url,
            type: 'POST',
            data: datos,
            dataType: 'json',
            success: function(respuesta) {
                mostrarMensaje(respuesta.mensaje, respuesta.estado);
                if(respuesta.estado === "ok") {
                    $(`#${formId}`)[0].reset();
                }
            },
            error: function() {
                mostrarMensaje("Error de conexión con el servidor", "error");
            }
        });
    }
    function mostrarMensaje(texto, tipo) {
        $('#mensaje').removeClass('ok error')
                      .addClass(tipo)
                      .text(texto)
                      .fadeIn();
    }


    $('#form-login').submit(function(e) {
        e.preventDefault();
        let email = $('#login-email').val().trim();
        let pass = $('#login-pass').val().trim();

        if(email === "" || pass === "") {
            mostrarMensaje("Por favor, rellena todos los campos", "error");
            return;
        }

        enviarFormulario(URL_BASE + 'login.php', { email: email, password: pass }, 'form-login');
    });

    $('#form-registro').submit(function(e) {
        e.preventDefault();
        let nombre = $('#reg-nombre').val().trim();
        let email = $('#reg-email').val().trim();
        let pass = $('#reg-pass').val().trim();

        if(nombre === "" || email === "" || pass === "") {
            mostrarMensaje("Todos los campos son obligatorios", "error");
            return;
        }

        enviarFormulario(URL_BASE + 'registro.php', { nombre: nombre, email: email, password: pass }, 'form-registro');
    });

    $('#form-recuperar').submit(function(e) {
        e.preventDefault();
        let email = $('#rec-email').val().trim();

        if(email === "") {
            mostrarMensaje("Introduce tu email", "error");
            return;
        }

        enviarFormulario(URL_BASE + 'recuperar.php', { email: email }, 'form-recuperar');
    });
});