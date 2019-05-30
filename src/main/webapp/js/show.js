(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            method: 'GET',
            url: '/ZoologicoNuevasTecnologias/api/show',
            dataType: 'json',
            contentType: 'application/json'
        }).done(function (data) {
            for (var i = 0; i < data.length; i++) {
                var tableRow = $('<tr>');
                // División de la fila
                //cada campo con su correspondiente valor
                var idEncargado = $('<td>');
                idEncargado.text(data[i].idEncargado.idDocumento.nomDocumento);
                var zoo = $('<td>');
                zoo.text(data[i].idZoo.nomZoo);
                var nomShow = $('<td>');
                nomShow.text(data[i].nomShow);

                var acciones = $('<td>');
                var botonEliminar = $('<button>').addClass('btn btn-danger');
                botonEliminar.text('Eliminar').attr('data-id',data[i].idShow);//poner la id de la tabla o entidad
                botonEliminar.click(eliminar);
                var botonActualizar = $('<a href="/ZoologicoNuevasTecnologias/forms/crearShow.html?id='+ data[i].idFecHo+'">').addClass('btn btn-primary');//poner la id de la tabla o entidad
                //enrutar a la pagina de crear de cada servicio
                botonActualizar.text('Actualizar');

                acciones.append(botonEliminar);
                acciones.append(botonActualizar);

                tableRow.append(idEncargado);
                tableRow.append(zoo);
                tableRow.append(nomShow);
                tableRow.append(acciones);

                $('#tableShow table tbody').append(tableRow);//la id del div donde se encuentra la tabla cambiarlo a gusto
            }
            console.log(data);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });

    function eliminar(event){
        $.ajax({
            method: 'DELETE',
            url:'/ZoologicoNuevasTecnologias/api/show/'+$(this).attr('data-id'),//enrutar con el servicio requerido
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
