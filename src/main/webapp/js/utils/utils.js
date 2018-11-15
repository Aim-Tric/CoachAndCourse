var log = console.log.bind(console);

function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null)
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

function setCookie(name, value, day = '') {
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
            showAlert(msgs[keys[i]]);
            return isVaild;
        }
    }
    // var usernameIllegal = regex_illegal.test(form[0].value); // 用户名
    // var emailIllegal = regex_email.test(form[1].value);
    // var isPasswordMatch = form[3].value == form[4].value;
    //
    // return emailIllegal && usernameIllegal && isPasswordMatch;
}

function showAlert(msg, level = 'warning') {
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
