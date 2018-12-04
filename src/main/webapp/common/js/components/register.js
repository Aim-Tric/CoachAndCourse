function initialRegister() {
    $('#do-register').click(function (e) {
        e.stopPropagation();
        e.preventDefault();
        var arr = {};
        var $form = $('form');
        var form = $form.serializeArray();
        /**
         * 1. 用户名密码不能为空
         * 2. 两次密码必须匹配
         * 3. 用户名密码,邮箱，必须符合规则
         */
        if (checkSpell(form)) {
            return;
        }
        $.each(form, function () {
            if (this.name === 'password_again')
                return;
            arr[this.name] = this.value;
        });
        $.ajax({
            type: 'POST',
            url: '/application/servlet/user/register',
            dataType: 'text',
            data: {'json': JSON.stringify(arr)},
            success: function (result) {
                var pw = $('#showAlert-pw');
                var popText = '注册失败，该用户已被注册'
                pw.removeClass("hidden");
                pw.removeClass('showAlert-warning')
                    .addClass('showAlert-success')
                    .text(popText);
                if (result === 'RESULT_FAILED')
                    return;
                popText = arr['username'] + " 注册成功! ";
                var fadeSec = 3;
                setInterval(function () {
                    pw.text(arr['username'] + " 注册成功! " + fadeSec + "s 后调回主页面");
                    fadeSec -= 1;
                    if (fadeSec === 0) {
                        location.href = '/index.jsp'
                    }
                }, fadeSec * 1000);
            },
            error: function () {
                $('#showAlert-pw').removeClass("hidden").children('span').text("网络出错，请检查你的网络和防火墙设置");
            }
        });
    });
}