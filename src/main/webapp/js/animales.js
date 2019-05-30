(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            method: 'GET',
            url: '/ZoologicoNuevasTecnologias/api/animal',
            dataType: 'json',
            contentType: 'application/json'
        }).done(function (data) {
            for (var i = 0; i < data.length; i++) {
                var tableRow = $('<tr>');
                // División de la fila
                //cada campo con su correspondiente valor
                var nombre = $('<td>');
                nombre.text(data[i].nombre);
                var nombreC = $('<td>');
                nombreC.text(data[i].nombreCientificoAnimal);
                var tipo = $('<td>');
                tipo.text(data[i].idTipoAnimal.nombreTipoAnimal);
                var alimento = $('<td>');
                alimento.text(data[i].idAlimentacion.nombreAlimento);
                var especie = $('<td>');
                especie.text(data[i].especieAnimal);
                var descripcion = $('<td>');
                descripcion.text(data[i].descripcionAnimal);
                var cuidador = $('<td>');
                cuidador.text(data[i].idCuidador.idCuidador);


                var acciones = $('<td>');
                var botonEliminar = $('<button>').addClass('btn btn-danger');
                botonEliminar.text('Eliminar').attr('data-id',data[i].idAnimal);//poner la id de la tabla o entidad
                botonEliminar.click(eliminar);
                var botonActualizar = $('<a href="/ZoologicoNuevasTecnologias/forms/crearAnimal.html?id='+ data[i].idAnimal+'">').addClass('btn btn-primary');//poner la id de la tabla o entidad
                //enrutar a la pagina de crear de cada servicio
                botonActualizar.text('Actualizar');

                acciones.append(botonEliminar);
                acciones.append(botonActualizar);

                tableRow.append(nombre);
                tableRow.append(nombreC);
                tableRow.append(tipo);
                tableRow.append(alimento);
                tableRow.append(especie);
                tableRow.append(descripcion);
                tableRow.append(cuidador);
                tableRow.append(acciones);

                $('#tableAnimal table tbody').append(tableRow);//la id del div donde se encuentra la tabla cambiarlo a gusto
            }
            console.log(data);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });

    function eliminar(event){
        $.ajax({
            method: 'DELETE',
            url:'/ZoologicoNuevasTecnologias/api/animal/'+$(this).attr('data-id'),//enrutar con el servicio requerido
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
