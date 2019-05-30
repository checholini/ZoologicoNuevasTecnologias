(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            method: 'GET',
            url: '/ZoologicoNuevasTecnologias/api/tipoanimal',
            dataType: 'json',
            contentType: 'application/json'
        }).done(function (data) {
            for (var i = 0; i < data.length; i++) {
                var id = data[i].idTipoAnimal;
                var nombre = data[i].nombreTipoAnimal;
                var option = "<option value=" + id + ">" + nombre + "</option>"
                console.log(option);
                $( "#tipo" ).append(option);
            }
            console.log(data);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });
})(jQuery);
