$(function () {
    var log = console.log.bind(console);
    $('#do-login').click(function (e) {
        e.stopPropagation()
        e.preventDefault()
        var arr = {};
        var $form = $('form');
        var form = $form.serializeArray();
        $.each(form, function () {
            arr[this.name] = this.value;
        });
        $.ajax({
            type: 'POST',
            url: './application/user/login',
            dataType: 'text',
            data: {'user': JSON.stringify(arr)},
            success : function (result) {
                var pw = $('#alert-pw');
                pw.removeClass("hidden");
                if (result == 'RESULT_FAILED') {
                    return;
                }
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
    });
    $('#do-register').click(function (e) {
        e.stopPropagation()
        e.preventDefault()
        var arr = {};
        var $form = $('form');
        var form = $form.serializeArray();

        function checkSpell(form) {
            var regex_illegal = new RegExp("[\\w!#$%&'*+/=?^_`{|}~-]*([!#$%&'*+/=?^_`{|}~-])[\\w!#$%&'*+/=?^_`{|}~-]*");
            var regex_email = new RegExp("[\\w!#$%&'*+/=?^_`{|}~-]+" +
                "(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@" +
                "(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w]" +
                "(?:[\\w-]*[\\w])?");
            var msg = {
                'usernameIllegal': '用户名存在非法字符，请修改再试',
                'emailIllegal': '请填写正确的邮箱地址',
                'passwordDismatch': '两次密码不匹配，请修改再试',
                'usernameEmpty': '用户名不能为空',
                'emailEmpty': '邮箱不能为空',
                'passwordEmpty': '密码不能为空',
                'nicknameEmpty': '昵称不能为空',
            }
            var check = {
                'usernameIllegal': regex_illegal.test(form[0].value),
                'emailIllegal': !regex_email.test(form[1].value),
                'passwordDismatch': form[3].value != form[4].value,
                'usernameEmpty': form[0].value == '',
                'emailEmpty': form[1].value == '',
                'passwordEmpty': form[3].value == '',
                'nicknameEmpty': form[2].value == '',
            }
            var keys = []
            for (var key in check) {
                keys.push(key)
            }
            for (var i = 0; i < keys.length; i++) {
                var isVaild = check[keys[i]]
                log('test: ', keys[i], isVaild);
                if (isVaild) {
                    alert(msg[keys[i]])
                    return isVaild
                }
            }
            // var usernameIllegal = regex_illegal.test(form[0].value); // 用户名
            // var emailIllegal = regex_email.test(form[1].value);
            // var isPasswordMatch = form[3].value == form[4].value;
            //
            // return emailIllegal && usernameIllegal && isPasswordMatch;
        }

        /**
         * 1. 用户名密码不能为空
         * 2. 两次密码必须匹配
         * 3. 用户名密码,邮箱，必须符合规则
         */
        if (checkSpell(form)) {
            return;
        }
        $.each(form, function () {
            if (this.name == 'password_again')
                return;
            arr[this.name] = this.value;
        });
        $.ajax({
            type: 'POST',
            url: './application/user/register',
            dataType: 'text',
            data: {'user': JSON.stringify(arr)},
            success: function (result) {
                var pw = $('#alert-pw');
                var popText = '注册失败，该用户已被注册'
                pw.removeClass("hidden");
                pw.removeClass('alert-warning')
                    .addClass('alert-success')
                    .text(popText);
                if (result == 'RESULT_FAILED')
                    return
                popText = arr['username'] + " 注册成功! ";
                var fadeSec = 3;
                setInterval(function () {
                    pw.text(arr['username'] + " 注册成功! " + fadeSec + "s 后调回主页面");
                    fadeSec -= 1
                    if (fadeSec == 0) {
                        location.href = '/index.jsp'
                    }
                }, fadeSec * 1000);
                // $('form').children(':not(".alert")').remove();
            },
            error: function () {
                $('#alert-pw').removeClass("hidden").children('span').text("网络出错，请检查你的网络和防火墙设置");
            }
        });
    });
});
