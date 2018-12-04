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


/**
 * 提示框组件
 * @param alertAdapter 提示框的内容信息对象
 * @param fadeout_sec 淡出时间
 * @param callback 处理后续事件的回调方法
 */
function showAdaptAlert(alertAdapter) {
    var a = alertAdapter;
    var fadeout_sec = a.fadeout_sec || a.sec || config.delay_short;
    if (a.adapter) {
        var adapter = a.adapter
        __showAlert(adapter.msg, adapter.level, fadeout_sec, a.callback);
    } else {
        __showAlert(a.msg, a.level, fadeout_sec, a.callback);
    }
}

function __showAlert(msg, level = 'warning', fadeout_sec = config.delay_short, callback) {
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
    __showThenDie($alert_obj, fadeout_sec, callback)
};

function __showThenDie(target, sec, callback) {
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


/**
 * 在表单发送完成后才能再次点击
 */
function toggleForm(selector) {
    var form = $(selector);
    form.toggleFormKey = !form.toggleFormKey;
    var arr = [];
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
        // 如果toggle存在就是toggle 否则就是true
        arr[i].disabled = form.toggleFormKey || true;
    }
}


