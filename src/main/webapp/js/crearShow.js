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
            url: '/ZoologicoNuevasTecnologias/api/show' + getUrlParameter('id'),
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            var idEncargado = $('#idEncargado').val(data.idEncargado);
            var zoo = $('#zoo').val(data.idZoo);
            var nomShow = $('#nomShow').val(data.nomShow);
            var id = data.id;
            $('#crearBoton').text("Actualizar").click(function (event) {
                $.ajax({
                    method: 'PUT',
                    url: '/ZoologicoNuevasTecnologias/api/lugar' + id,
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify({
                        idShow:id,
                        idZoo: {
                            idZoo : zoo},
                        idEncargado: {
                            idEncargado: idEncargado
                        },
                        nomShow : nomShow
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
            var idEncargado = $('#idEncargado').val();
            var zoo = $('#zoo').val();
            var nomShow = $('#nomShow').val();
            $.ajax({
                method: 'POST',
                url: '/ZoologicoNuevasTecnologias/api/show',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify({
                        idZoo: {
                            idZoo : zoo},
                        idEncargado: {
                            idEncargado: idEncargado
                        },
                        nomShow : nomShow
                })
            }).done(function (data) {
                window.location.href = '/ZoologicoNuevasTecnologias';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }



})(jQuery);