function initialLogin() {
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
            url: '/application/servlet/user/login',
            dataType: 'text',
            data: {'json': JSON.stringify(arr)},
            success: function (result) {
                var ret = JSON.parse(result);
                var key = ret['result_code'];
                var adapter = alert_dict[key];
                var parent = $form.parents('.panel');
                showAlert(adapter.msg, adapter.level);
                toggleForm($form);
                setTimeout(function () {
                    window.location.href = "dashboard.jsp";
                }, config.delay_short * 1000);
            },
            error: function () {
                showAlert(lang('network_disconnect'), 'error');
            }
        });
    });
}

