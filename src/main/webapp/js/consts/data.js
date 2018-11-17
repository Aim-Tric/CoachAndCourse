var alert_dict = {
    'RESULT_OK': {
        msg: lang('operation_success'),
        level: 'success',
    },
    'RESULT_FAILED': {
        msg: lang('operation_failed'),
        level: 'warning',
    },
    'RESULT_CANCEL': {
        msg: lang('network_disconnect'),
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