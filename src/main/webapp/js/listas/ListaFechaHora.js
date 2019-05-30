(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            method: 'GET',
            url: '/ZoologicoNuevasTecnologias/api/fechayhora',
            dataType: 'json',
            contentType: 'application/json'
        }).done(function (data) {
            for (var i = 0; i < data.length; i++) {
              var id = data[i].idFecHo;
              var nombre =data[i].idLugar.nomLugar;
              var fecha =data[i].fecha;
              var hora =data[i].hora;
              var option = "<option value=" + id + ">" + nombre + hora + fecha + "</option>";
              console.log(option);
              $( "#fecha" ).append(option);
            }
            console.log(data);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });

})(jQuery);