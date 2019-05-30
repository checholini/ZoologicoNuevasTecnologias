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
            url: '/ZoologicoNuevasTecnologias-develop/api/cuidador/' + getUrlParameter('id'),
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            //Crear variables con los camnpos de la entidad y referenciar los campos en el formulario
            var fechaNacimientoCuidador = $('#fechaNacimientoCuidador').val(data.fechaNacimientoCuidador);
            var id = data.idCuidador;
            $('#CrearBoton').text("Actualizar").click(function (event) {
              console.log(id);
                $.ajax({
                    method: 'PUT',
                    //Cambiar Ruta al servicio necesitado
                    url: '/ZoologicoNuevasTecnologias-develop/api/cuidador/' + id,
                    contentType: 'application/json',
                    dataType: 'json',
                    //Mapear datos si hay un json dentro de otro, añadir "id": {"id" : valorId}
                    data: JSON.stringify({
                        idCuidador:id,
                        fechaNacimientoCuidador: fechaNacimientoCuidador.val(),
                    })
                }).done(function (data) {
                    window.location.href = '/ZoologicoNuevasTecnologias-develop/shows.html';
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
            var fechaNacimientoCuidador = $('#fechaNacimientoCuidador').val();
            //Mapear datos si hay un json dentro de otro, añadir "id": {"id" : valorId}
            $.ajax({
                method: 'POST',
                 //Cambiar Ruta al servicio necesitado
                url: '/ZoologicoNuevasTecnologias-develop/api/cuidador/',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify({
                        fechaNacimientoCuidador: fechaNacimientoCuidador,
                })
            }).done(function (data) {
                window.location.href = '/ZoologicoNuevasTecnologias-develop';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }



})(jQuery);
