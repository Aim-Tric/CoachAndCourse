$(function () {
    var log = console.log.bind(console);

    function setCookie(name, value, day=1) {
        var exp = new Date();
        exp.setTime(exp.getTime() + day * 24 * 60 * 60 * 1000);
        document.cookie = name + "=" + decodeURI(value) + ";expires=" + exp.toGMTString();
    }

    function getCookie(name) {
        var ret = null;
        var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
        if (arr = document.cookie.match(reg))
            ret = unescape(arr[2]);
        return ret;
    }

    function delCookie(name) {
        var exp = new Date();
        exp.setTime(exp.getTime() - 1);
        var cval = getCookie(name);
        if (cval != null)
            document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
    }

    var alert = function (msg, level = 'warning') {
        var title = {
            'success': '成功',
            'warning': '警告',
            'info': '信息',
            'error': '错误',
        };
        var $alert_div = `<div class="alert alert-${level}"> 
                            <a href='#' class='close' data-dismiss='alert'>&times;</a>
                            <b>${title[level]}</b>${msg}</div>`;
        $('body').append($alert_div).css('display', 'none').slideDown('fast', 6000, function () {
            $(this).remove()
        })
    };
    $('#do-login').click(function (e) {
        e.stopPropagation();
        e.preventDefault();
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
            success: function (result) {
                var ret = JSON.parse(result);

                log('success', ret, ret['result'], ret['nickname']);
                var pw = $('#alert-pw');
                pw.removeClass("hidden");
                if (ret['result'] == 'RESULT_FAILED') {
                    return;
                }
                pw.removeClass('alert-warning')
                    .addClass('alert-success')
                    .text(arr['username'] + " 登陆成功! ");
                var fadeSec = 3;
                setInterval(function () {
                    pw.text(arr['username'] + " 登陆成功! " + fadeSec + "s 后此对话框消失");
                    fadeSec -= 1
                }, 1000);
                $('form').children(':not(".alert")').remove();
                setTimeout(function () {
                    $('form').parent().hide('slow', function () {
                        // you can do any animation effect here
                        window.location.reload(false);
                    });
                }, 3000);

            },
            error: function () {
                $('#alert-pw').removeClass("hidden").children('span').text("网络出错，请检查你的网络和防火墙设置");
            }
        });
    });
    $('#do-register').click(function (e) {
        e.stopPropagation();
        e.preventDefault();
        var arr = {};
        var $form = $('form');
        var form = $form.serializeArray();

        function checkSpell(form) {
            var regex_illegal = new RegExp("[\\w!#$%&'*+/=?^_`{|}~-]*([!#$%&'*+/=?^_`{|}~-])[\\w!#$%&'*+/=?^_`{|}~-]*");
            var regex_email = new RegExp("[\\w!#$%&'*+/=?^_`{|}~-]+" +
                "(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@" +
                "(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w]" +
                "(?:[\\w-]*[\\w])?");
            var msgs = {
                'usernameIllegal': '用户名存在非法字符，请修改再试',
                'emailIllegal': '请填写正确的邮箱地址',
                'passwordDismatch': '两次密码不匹配，请修改再试',
                'usernameEmpty': '用户名不能为空',
                'emailEmpty': '邮箱不能为空',
                'passwordEmpty': '密码不能为空',
                'nicknameEmpty': '昵称不能为空',
            };
            var checks = {
                'usernameIllegal': regex_illegal.test(form[0].value),
                'emailIllegal': !regex_email.test(form[1].value),
                'passwordDismatch': form[3].value !== form[4].value,
                'usernameEmpty': form[0].value === '',
                'emailEmpty': form[1].value === '',
                'passwordEmpty': form[3].value === '',
                'nicknameEmpty': form[2].value === '',
            };
            var keys = [];
            for (var key in checks) {
                keys.push(key)
            }
            for (var i = 0; i < keys.length; i++) {
                var isVaild = checks[keys[i]];
                log('test: ', keys[i], isVaild);
                if (isVaild) {
                    alert(msgs[keys[i]]);
                    return isVaild;
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
            if (this.name === 'password_again')
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
                $('#alert-pw').removeClass("hidden").children('span').text("网络出错，请检查你的网络和防火墙设置");
            }
        });
    });
    $('#logout-btn').click(function (e) {
        //    TODO: 注销登录
        delCookie('USERID');
        delCookie('CNCSID');
        window.location.reload(false);
    })
});
