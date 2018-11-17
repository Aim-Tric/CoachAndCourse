var log = console.log.bind(console);

function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null)
        document.cookie = name + "=" + cval + ";expires=" + exp.toUTCString() + "; path=/";
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

    var spell_rule = {
        'usernameIllegal': {
            msg: lang('username_illegal'),
            condition: regex.illegal.test(form[0].value),
        },
        'emailIllegal': {
            msg: lang('email_illegal'),
            condition: !regex.email.test(form[1].value),
        },
        'passwordMismatch': {
            msg: lang('password_mismatch'),
            condition: form[3].value !== form[4].value,
        },
        'usernameEmpty': {
            msg: lang('username_empty'),
            condition: form[0].value === '',
        },
        'emailEmpty': {
            msg: lang('email_empty'),
            condition: form[1].value === '',
        },
        'passwordEmpty': {
            msg: lang('password_empty'),
            condition: form[3].value === '',
        },
        'nicknameEmpty': {
            msg: lang('nickname_empty'),
            condition: form[2].value === '',
        },
    };

    var keys = [];
    for (var k in msgs) {
        keys.push(k)
    }
    for (var i = 0; i < keys.length; i++) {
        var k = keys[i];
        var check = spell_rule[k];
        var isVaild = check.condition;
        if (isVaild) {
            showAlert(check.msg);
            return isVaild;
        }
    }
    // var usernameIllegal = regex_illegal.test(form[0].value); // 用户名
    // var emailIllegal = regex_email.test(form[1].value);
    // var isPasswordMatch = form[3].value == form[4].value;
    //
    // return emailIllegal && usernameIllegal && isPasswordMatch;
}

function showAdaptAlert(alertAdapter, fadeout_sec = config.delay_short, callback) {
    showAlert(alertAdapter.msg, alertAdapter.level, fadeout_sec, callback);
}

function showAlert(msg, level = 'warning', fadeout_sec = config.delay_short, callback) {
    var $alert_div = `<div class="alert alert-${level} show-alert"> 
                            <a href='#' class='close' data-dismiss='alert'>&times;</a>
                            <b>${lang(level)} </b>${msg}</div>`;
    $('body').append($alert_div);
    var $alert_obj = $('.show-alert');
    $alert_obj.css({
        'display': 'none',
        'position' : 'fixed',
        'left' : '50%',
        'top' : '10%',
        'transform' : 'tansistion(-50%, -50%)',
    });
    showThenDie($alert_obj, fadeout_sec, callback)
};

function showThenDie(target, sec, callback) {
    $(target).fadeIn('fast', function () {
        var $self = $(this);
        setTimeout(function () {
            $self.fadeOut('fast', function () {
                $self.remove();
                callback && callback() // 如果有回调函数，则调用回调函数
            })
        }, sec * 1000);
    })
}

function form_datas() {
    var arr = {};
    var datas = $('form').serializeArray();
    $.each(datas, function () {
        arr[this.name] = this.value;
    });
    return arr;
}

function lang(key) {
    var translation = language[key]; // 拿到存了多们语言翻译句的字典，下一步要判断用的是哪门语言
    return translation[language.using]; // 把目标语言的翻译句返回
}

function toggleForm(form) {
    form.toggleFormKey = !form.toggleFormKey;
    var arr = [];
    log('form', form.children('input'))
    form.find('input').each(function () {
        arr.push(this);
    });
    form.find('button').each(function () {
        arr.push(this);
    });
    form.find('a').each(function () {
        arr.push(this);
    });


    for (let i = 0; i < arr.length; i++) {
        arr[i].disabled = form.toggleFormKey || true;
    }
}