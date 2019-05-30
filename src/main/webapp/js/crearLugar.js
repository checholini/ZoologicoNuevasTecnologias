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
            url: '/ZoologicoNuevasTecnologias/api/lugar' + getUrlParameter('id'),
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            var nomLugar = $('#nomLugar').val(data.nomLugar);
            var direccionLugar = $('#direccionLugar').val(data.direccionLugar);
            var id = data.id;
            $('#crearBoton').text("Actualizar").click(function (event) {
                $.ajax({
                    method: 'PUT',
                    url: '/ZoologicoNuevasTecnologias/api/lugar' + id,
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify({
                        idLugar:id,
                        nomLugar: nomLugar,
                        direccionLugar: direccionLugar
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
            var nomLugar = $('#nomLugar').val();
            var direccionLugar = $('#direccionLugar').val();
            $.ajax({
                method: 'POST',
                url: '/ZoologicoNuevasTecnologias/api/lugar',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify({
                        nomLugar: nomLugar,
                        direccionLugar: direccionLugar
                })
            }).done(function (data) {
                window.location.href = '/ZoologicoNuevasTecnologias';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }



})(jQuery);