(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            method: 'GET',
            url: '/ZoologicoNuevasTecnologias/api/documento',
            dataType: 'json',
            contentType: 'application/json'
        }).done(function (data) {
            for (var i = 0; i < data.length; i++) {
                var id = data[i].idDocumento;
                var nombre = data[i].nomDocumento;
                var option = "<option value=" + id + ">" + nombre + "</option>"
                console.log(option);
                $( "#doc" ).append(option);
            }
            console.log(data);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });
})(jQuery);
