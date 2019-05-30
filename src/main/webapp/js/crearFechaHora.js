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
            url: '/ZoologicoNuevasTecnologias-develop/api/fechayhora' + getUrlParameter('id'),
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            var idLugar = $('#idLugar').val(data.idLugar);
            var fecha = $('#direccionLugar').val(data.fecha);
            var hora = $('#direccionLugar').val(data.hora);
            var id = data.id;
            $('#crearBoton').text("Actualizar").click(function (event) {
                $.ajax({
                    method: 'PUT',
                    url: '/ZoologicoNuevasTecnologias-develop/api/fechayhora' + id,
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify({
                        idFecHo: id,
                        idLugar:idLugar,
                        nomLugar: nomLugar,
                        direccionLugar: direccionLugar
                    })
                }).done(function (data) {
                    window.location.href = '/ZoologicoNuevasTecnologias-develop';
                }).fail(function (xhr, status, error) {
                    console.log.error;
                });
            });

        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#crearBoton').click(function (event) {
             var idLugar = $('#idLugar').val();
            var fecha = $('#direccionLugar').val();
            var hora = $('#direccionLugar').val();
            $.ajax({
                method: 'POST',
                url: '/ZoologicoNuevasTecnologias-develop/api/fechayhora',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify({
                        idLugar:{
                            idLugar: idLugar
                        },
                        nomLugar: nomLugar,
                        direccionLugar: direccionLugar
                })
            }).done(function (data) {
                window.location.href = '/ZoologicoNuevasTecnologias-develop';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }



})(jQuery);