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
            url: '/ZoologicoNuevasTecnologias/api/animal/' + getUrlParameter('id'),
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            //Crear variables con los camnpos de la entidad y referenciar los campos en el formulario
            var nombre = $('#nombre').val(data.nombre);
            var nombreC = $('#nombreC').val(data.nombreCientificoAnimal);
            var tipo = $('#tipo').val(data.idTipoAnimal.idTipoAnimal);
            var alimento = $('#alimento').val(data.idAlimentacion.idAlimentacion);
            var especie = $('#especie').val(data.especieAnimal);
            var descripcion = $('#descripcion').val(data.descripcionAnimal);
            var cuidador = $('#cuidador').val(data.idCuidador.idCuidador);
            var id = data.idAnimal;
            $('#CrearBoton').text("Actualizar").click(function (event) {
              console.log(id);
                $.ajax({
                    method: 'PUT',
                    //Cambiar Ruta al servicio necesitado
                    url: '/ZoologicoNuevasTecnologias/api/animal/' + id,
                    contentType: 'application/json',
                    dataType: 'json',
                    //Mapear datos si hay un json dentro de otro, añadir "id": {"id" : valorId}
                    data: JSON.stringify({
                        idAnimal:id,
                        nombreCientificoAnimal: nombreC.val(),
                        nombre: nombre.val(),
                        idTipoAnimal:{ idTipoAnimal: tipo.val() },
                        idAlimentacion:{ idAlimentacion: alimento.val() },
                        especieAnimal: especie.val(),
                        descripcionAnimal: descripcion.val(),
                        idCuidador:{idCuidador: cuidador.val()}
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
            var nombreC = $('#nombreC').val();
            var tipo = $('#tipo').val();
            var alimento = $('#alimento').val();
            var especie = $('#especie').val();
            var descripcion = $('#descripcion').val();
            var cuidador = $('#cuidador').val();
            //Mapear datos si hay un json dentro de otro, añadir "id": {"id" : valorId}
            $.ajax({
                method: 'POST',
                 //Cambiar Ruta al servicio necesitado
                url: '/ZoologicoNuevasTecnologias/api/animal/',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify({
                  nombreCientificoAnimal: nombreC,
                  nombre: nombre,
                  idTipoAnimal:{ idTipoAnimal: tipo },
                  idAlimentacion:{ idAlimentacion: alimento },
                  especieAnimal: especie,
                  descripcionAnimal: descripcion,
                  idCuidador:{idCuidador: cuidador}
                    })
            }).done(function (data) {
                window.location.href = '/ZoologicoNuevasTecnologias/animales.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);
