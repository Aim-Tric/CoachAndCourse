$(function () {
    $('form').click(function () {
        var arr = {};
        var form = $(this).serializeArray();
        $.each(form, function () {
            arr[this.name] = this.value;
        });
        var $self = $(this);
        $.ajax({
            method: 'post',
            url: 'servlet/login',
            dataType: 'text',
            data: JSON.stringify(arr),
            success : function (result) {
                $self.html("<div class='alert alert-success'>" +
                    "<a href='#' class='close' data-dismiss='alert'>&times;</a>" +
                    "<strong>登陆成功！</strong>" + result + "</div>")
            },
            error: function () {
                $self.html("<div class='alert alert-warning'>" +
                    "<a href='#' class='close' data-dismiss='alert'>&times;</a>" +
                    "<strong>警告！</strong>您的网络连接有问题。</div>")
            }
        });
    });

});
