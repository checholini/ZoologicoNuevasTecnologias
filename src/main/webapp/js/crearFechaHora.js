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
            url: '/ZoologicoNuevasTecnologias/api/fechayhora/' + getUrlParameter('id'),
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            //Crear variables con los campos de la entidad y referenciar los campos en el formulario
            var idLugar = $('#idLugar').val(data.idLugar.idLugar);
            var fecha = $('#fecha').val(data.fecha);
            var hora = $('#hora').val(data.hora);
            var id = data.idFecHo;
            $('#crearBoton').text("Actualizar").click(function (event) {
                console.log(id);
                $.ajax({
                    method: 'PUT',
                     //Cambiar Ruta al servicio necesitado
                    url: '/ZoologicoNuevasTecnologias/api/fechayhora/' + id,
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify({
                        //Mapear datos si hay un json dentro de otro, añadir "id": {"id" : valorId}
                        idFecHo: id,
                        idLugar:{
                            idLugar : idLugar.val()
                        },
                        fecha: fecha.val(),
                        hora: hora.val()
                    })
                }).done(function (data) {
                    window.location.href = '/ZoologicoNuevasTecnologias/shows.html';
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
            var idLugar = $('#idLugar').val();
            var fecha = $('#fecha').val();
            var hora = $('#hora').val();
            console.log(idLugar);
            //Mapear datos si hay un json dentro de otro, añadir "id": {"id" : valorId}
            $.ajax({
                method: 'POST',
                 //Cambiar Ruta al servicio necesitado
                url: '/ZoologicoNuevasTecnologias/api/fechayhora',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify({
                        idLugar:{
                            idLugar : idLugar
                        },
                        fecha: fecha,
                        hora: hora
                })
            }).done(function (data) {
                window.location.href = '/ZoologicoNuevasTecnologias/shows.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }



})(jQuery);
