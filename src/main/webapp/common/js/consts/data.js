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

var regex = {
    illegal: new RegExp("[\\w!#$%&'*+/=?^_`{|}~-]*([!#$%&'*+/=?^_`{|}~-])[\\w!#$%&'*+/=?^_`{|}~-]*"),
    email: new RegExp("[\\w!#$%&'*+/=?^_`{|}~-]+" +
        "(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@" +
        "(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w]" +
        "(?:[\\w-]*[\\w])?"),
}