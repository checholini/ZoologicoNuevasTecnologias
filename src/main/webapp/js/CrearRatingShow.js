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
            url: '/ZoologicoNuevasTecnologias-develop/api/Rating_Show/' + getUrlParameter('id'),
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            //Crear variables con los campos de la entidad y referenciar los campos en el formulario
            var idShow = $('#idShow').val(data.idShow);
            var rating = $('#zoo').val(data.rating);
            var comentaria = $('#comentaria').val(data.comentario);
            var id = data.idRatingShow;
            $('#crearBoton').text("Actualizar").click(function (event) {
                console.log(id);
                $.ajax({
                    method: 'PUT',
                     //Cambiar Ruta al servicio necesitado
                    url: '/ZoologicoNuevasTecnologias-develop/api/Rating_Show/' + id,
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify({
                        //Mapear datos si hay un json dentro de otro, añadir "id": {"id" : valorId}
                        idRatingShow:id,
                        idShow: {
                            idShow : idShow},
                        rating : rating,
                        comentario : comentaria
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
        $('#crearBoton').click(function (event) {
              //Crear variables con los camnpos de la entidad y referenciar los campos en el formulario
            var idShow = $('#idShow').val();
            var rating = $('#zoo').val();
            var comentaria = $('#comentaria').val();
            //Mapear datos si hay un json dentro de otro, añadir "id": {"id" : valorId}
            $.ajax({
                method: 'POST',
                 //Cambiar Ruta al servicio necesitado
                url: '/ZoologicoNuevasTecnologias-develop/api/Rating_Show',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify({
                        idShow: {
                            idShow : idShow},
                        rating : rating,
                        comentario : comentaria
                })
            }).done(function (data) {
                window.location.href = '/ZoologicoNuevasTecnologias-develop/shows.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }



})(jQuery);