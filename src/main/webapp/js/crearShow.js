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
            url: '/ZoologicoNuevasTecnologias/api/show/' + getUrlParameter('id'),
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            //Crear variables con los campos de la entidad y referenciar los campos en el formulario
            var idEncargado = $('#idEncargado').val(data.idEncargado.idEncargado);
            var zoo = $('#zoo').val(data.idZoo);
            var nomShow = $('#nomShow').val(data.nomShow);
            var fecha = $('#fecha').val(data.idFecHo.idFecHo)
            var id = data.idShow;
            $('#crearBoton').text("Actualizar").click(function (event) {
                console.log(id);
                $.ajax({
                    method: 'PUT',
                     //Cambiar Ruta al servicio necesitado
                    url: '/ZoologicoNuevasTecnologias/api/show/' + id,
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify({
                        //Mapear datos si hay un json dentro de otro, añadir "id": {"id" : valorId}
                        idShow:id,
                        idZoo: {
                            idZoo : zoo.val()},
                        idEncargado: {
                            idEncargado: idEncargado.val()
                        },
                        idFecHo:{
                          idFecHo: fecha.val()
                        },
                        nomShow : nomShow.val()
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
            var idEncargado = $('#idEncargado').val();
            var zoo = $('#zoo').val();
            var nomShow = $('#nomShow').val();
            var fecha = $('#fecha').val();
            //Mapear datos si hay un json dentro de otro, añadir "id": {"id" : valorId}
            $.ajax({
                method: 'POST',
                 //Cambiar Ruta al servicio necesitado
                url: '/ZoologicoNuevasTecnologias/api/show',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify({
                        idZoo: {
                            idZoo : zoo},
                        idEncargado: {
                            idEncargado: idEncargado
                        },
                        idFecHo:{
                          idFecHo: fecha
                        },
                        nomShow : nomShow
                })
            }).done(function (data) {
                window.location.href = '/ZoologicoNuevasTecnologias/shows.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }



})(jQuery);
