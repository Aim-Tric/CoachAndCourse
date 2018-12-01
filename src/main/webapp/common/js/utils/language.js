var LANG_ZH_CN = {
    'operation_success': '操作成功',
    'operation_failed': '操作失败',
    'network_disconnect': '网络状态不好，请检查你的网络和防火墙设置',
    'login_success': ' 登陆成功！',
    'login_failed': ' 登陆失败！用户名或密码错误 ',
    'account_do_not_exist': ' 登陆失败！用户名不存在 ',
    'sec_to_fadeout': ' 秒后此对话框消失',
    'username_illegal': '用户名存在非法字符，请修改再试',
    'email_illegal': '请填写正确的邮箱地址',
    'password_mismatch': '两次密码不匹配，请修改再试',
    'username_empty': '用户名不能为空',
    'email_empty': '邮箱不能为空',
    'nickname_empty': '昵称不能为空',
    'success': '成功',
    'warning': '警告',
    'info': '信息',
    'error': '错误',
};

function lang(key) {
    // 拿到存了多们语言翻译句的字典，下一步要判断用的是哪门语言
    return language.using[key]; // 把目标语言的翻译句返回
}


var language = {
    // 可用的表如下：LANG_EN, LANG_ZH_CN, LANG_JP, LANG_FR ... 但是，除了LANG_ZH_CN都没有翻译。
    using: LANG_ZH_CN,
};

var alert_dict = {
    'RESULT_OK': {
        msg: lang('login_success'),
        level: 'success',
    },
    'RESULT_FAILED': {
        msg: lang('login_failed'),
        level: 'warning',
    },
    'RESULT_CANCEL': {
        msg: lang('account_do_not_exist'),
        level: 'error',
    },
};
