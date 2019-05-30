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
            url: '/ZoologicoNuevasTecnologias/api/Rating_Show' + getUrlParameter('id'),
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            var idShow = $('#idShow').val(data.idShow);
            var rating = $('#zoo').val(data.rating);
            var comentaria = $('#comentaria').val(data.comentario);
            var id = data.id;
            $('#crearBoton').text("Actualizar").click(function (event) {
                $.ajax({
                    method: 'PUT',
                    url: '/ZoologicoNuevasTecnologias/api/lugar' + id,
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify({
                        idRatingShow:id,
                        idShow: {
                            idShow : idShow},
                        rating : rating,
                        comentario : comentaria
                    })
                }).done(function (data) {
                    window.location.href = '/ZoologicoNuevasTecnologias';
                }).fail(function (xhr, status, error) {
                    console.log.error;
                });
            });

        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#crearBoton').click(function (event) {
           var idShow = $('#idShow').val();
            var rating = $('#zoo').val();
            var comentaria = $('#comentaria').val();
            $.ajax({
                method: 'POST',
                url: '/ZoologicoNuevasTecnologias/api/Rating_Show',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify({
                        idZoo: {
                        idShow: {
                            idShow : idShow},
                        rating : rating,
                        comentario : comentaria
                })
            }).done(function (data) {
                window.location.href = '/ZoologicoNuevasTecnologias';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }



})(jQuery);