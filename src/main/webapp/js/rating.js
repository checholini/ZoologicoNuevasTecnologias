(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            method: 'GET',
            url: '/ZoologicoNuevasTecnologias/api/ratinganimal',
            dataType: 'json',
            contentType: 'application/json'
        }).done(function (data) {
            for (var i = 0; i < data.length; i++) {
                var tableRow = $('<tr>');
                // División de la fila
                //cada campo con su correspondiente valor
                var nombre = $('<td>');
                nombre.text(data[i].idAnimal.nombre);
                var calificacion = $('<td>');
                calificacion.text(data[i].calificacionAnimal);
                var comentario = $('<td>');
                comentario.text(data[i].comentarioAnimal);


                var acciones = $('<td>');
                var botonEliminar = $('<button>').addClass('btn btn-danger');
                botonEliminar.text('Eliminar').attr('data-id',data[i].idRatingAnimal);//poner la id de la tabla o entidad
                botonEliminar.click(eliminar);
                var botonActualizar = $('<a href="/ZoologicoNuevasTecnologias/forms/crearRating.html?id='+ data[i].idRatingAnimal+'">').addClass('btn btn-primary');//poner la id de la tabla o entidad
                //enrutar a la pagina de crear de cada servicio
                botonActualizar.text('Actualizar');

                acciones.append(botonEliminar);
                acciones.append(botonActualizar);

                tableRow.append(nombre);
                tableRow.append(calificacion);
                tableRow.append(comentario);
                tableRow.append(acciones);

                $('#tableRating table tbody').append(tableRow);//la id del div donde se encuentra la tabla cambiarlo a gusto
            }
            console.log(data);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });

    function eliminar(event){
        $.ajax({
            method: 'DELETE',
            url:'/ZoologicoNuevasTecnologias/api/ratinganimal/'+$(this).attr('data-id'),//enrutar con el servicio requerido
            contentType: 'application/json',
            dataType: 'json'
        }).done(function(data){
            console.log("Elemento eliminado");
            window.location.reload();
        }).fail(function(xhr, status, error){
            console.log(error);
        });
    }
})(jQuery);
