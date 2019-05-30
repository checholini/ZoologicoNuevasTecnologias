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
            url: '/ZoologicoNuevasTecnologias/api/ratinganimal/' + getUrlParameter('id'),
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            //Crear variables con los camnpos de la entidad y referenciar los campos en el formulario
            var nombre = $('#nombre').val(data.idAnimal.idAnimal);
            var calificacion = $('#calificacion').val(data.calificacionAnimal);
            var comentario = $('#comentario').val(data.comentarioAnimal);
            var id = data.idRatingAnimal;
            $('#CrearBoton').text("Actualizar").click(function (event) {
              console.log(id);
                $.ajax({
                    method: 'PUT',
                    //Cambiar Ruta al servicio necesitado
                    url: '/ZoologicoNuevasTecnologias/api/ratinganimal/' + id,
                    contentType: 'application/json',
                    dataType: 'json',
                    //Mapear datos si hay un json dentro de otro, añadir "id": {"id" : valorId}
                    data: JSON.stringify({
                        idRatingAnimal:id,
                        calificacionAnimal: calificacion.val(),
                        comentarioAnimal: comentario.val(),
                        idAnimal:{ idAnimal: nombre.val() }
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
            var calificacion = $('#calificacion').val();
            var comentario = $('#comentario').val();
            //Mapear datos si hay un json dentro de otro, añadir "id": {"id" : valorId}
            $.ajax({
                method: 'POST',
                 //Cambiar Ruta al servicio necesitado
                url: '/ZoologicoNuevasTecnologias/api/ratinganimal/',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify({
                  calificacionAnimal: calificacion,
                  comentarioAnimal: comentario,
                  idAnimal:{ idAnimal: nombre }
                    })
            }).done(function (data) {
                window.location.href = '/ZoologicoNuevasTecnologias/animales.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);
