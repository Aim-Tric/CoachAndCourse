$(function () {
    $('#do-login').click(function (e) {
        // e.stopPropagation();
        // e.preventDefault();
        var arr = {};
        var $form = $('form');
        var form = $form.serializeArray();
        $.each(form, function () {
            arr[this.name] = this.value;
        });

        $.ajax({
            type: 'Post',
            url: '/servlet/login',
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(arr),
            success : function (result) {
                $form.html("<div class='alert alert-success'>" +
                    "<a href='#' class='close' data-dismiss='alert'>&times;</a>" +
                    "<strong>" + result + "</strong></div>")
            },
            error: function () {
                $('#alert-pw').removeClass("hidden");
            }
        });
        return false
    });

});
