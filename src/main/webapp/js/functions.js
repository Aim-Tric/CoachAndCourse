$(function () {
    var log = console.log.bind(console);
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
            type: 'POST',
            url: './servlet/user/login',
            dataType: 'text',
            data: {'user': JSON.stringify(arr)},
            success : function (result) {
                var pw = $('#alert-pw');
                pw.removeClass("hidden");
                if (result == 'RESULT_FAILED') {
                    return;
                }
                log('out of if', $('form').children(':not(".alert")'))
                pw.removeClass('alert-warning')
                    .addClass('alert-success')
                    .text(arr['username'] + " 登陆成功! ");
                var fadeSec = 3;
                setInterval(function () {
                    pw.text(arr['username'] + " 登陆成功! " + fadeSec + "s 后此对话框消失");
                    fadeSec -= 1
                }, 1 * 1000);
                $('form').children(':not(".alert")').remove();
                setTimeout(function() {
                    $('form').hide('slow', function () {
                        $('.carousel').parent().fadeOut('fast').removeClass('col-lg-9').addClass('col-lg-12').fadeIn('fast');
                    });
                }, 3000);

            },
            error: function () {
                $('#alert-pw').removeClass("hidden").children('span').text("网络出错，请检查你的网络和防火墙设置");
            }
        });
        return false
    });

});
