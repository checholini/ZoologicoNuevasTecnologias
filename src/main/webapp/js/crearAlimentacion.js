(function ($) {
    var getUrlParameter = function getUrlParameter(sParam) {
        var sPageURL = decodeURIComponent(window.location.search.substring(1)),
                sURLVariables = sPageURL.split('&'),
                sParameterName,
                i;
        for (i = 0; i < sURLVariables.length; i++) {
            sParameterName = sURLVariables[i].split('=');
            if (sParameterName[0] === sParam) {
                return sParameterName [1] === undefined ? true : sParameterName[1];
            }
        }
    };

    if (getUrlParameter('id')) {
        $.ajax({
            method: 'GET',
            //Cambiar Ruta al servicio necesitado
            url: '/ZoologicoNuevasTecnologias/api/alimentacion/' + getUrlParameter('id'),
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            //Crear variables con los camnpos de la entidad y referenciar los campos en el formulario
            var nombre = $('#nombre').val(data.nombreAlimento);
            var cantidad = $('#cantidad').val(data.cantidadAlimento);
            var horarioM = $('#horarioM').val(data.horarioMañana);
            var horarioN = $('#horarioN').val(data.horarioTarde);
            var id = data.idAlimentacion;
            $('#CrearBoton').text("Actualizar").click(function (event) {
              console.log(id);
                $.ajax({
                    method: 'PUT',
                    //Cambiar Ruta al servicio necesitado
                    url: '/ZoologicoNuevasTecnologias/api/alimentacion/' + id,
                    contentType: 'application/json',
                    dataType: 'json',
                    //Mapear datos si hay un json dentro de otro, añadir "id": {"id" : valorId}
                    data: JSON.stringify({
                        idAlimentacion:id,
                        cantidadAlimento: cantidad.val(),
                        nombreAlimento: nombre.val(),
                        horarioMañana: horarioM.val(),
                        horarioTarde: horarioN.val()
                    })
                }).done(function (data) {
                    window.location.href = '/ZoologicoNuevasTecnologias/animales.html';
                }).fail(function (xhr, status, error) {
                    console.log.error;
                });
            });

        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#CrearBoton').click(function (event) {
            //Crear variables con los camnpos de la entidad y referenciar los campos en el formulario
            var nombre = $('#nombre').val();
            var cantidad = $('#cantidad').val();
            var horarioM = $('#horarioM').val();
            var horarioN = $('#horarioN').val();
            //Mapear datos si hay un json dentro de otro, añadir "id": {"id" : valorId}
            $.ajax({
                method: 'POST',
                 //Cambiar Ruta al servicio necesitado
                url: '/ZoologicoNuevasTecnologias/api/alimentacion/',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify({
                        cantidadAlimento: cantidad,
                        nombreAlimento: nombre,
                        horarioMañana: horarioM,
                        horarioTarde: horarioN
                    })
            }).done(function (data) {
                window.location.href = '/ZoologicoNuevasTecnologias/animales.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);
