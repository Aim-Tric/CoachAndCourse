function addClickListener(obj) {
    $(obj.id).click(function (e, obj, callback) {
        e.stopPropagation();
        e.preventDefault();
        $.ajax({
            type: 'Get',
            url: obj.url,
            success: function (result) {
                $('.template-inner').html(result);
                $.when($('form')).done(function (form) {
                    // TODO:为提交按钮添加ajax
                    // 这里registerAction[obj.type]拿到的是一个函数
                    // 将调用这个函数，参数为obj
                    var key = obj.type;
                    // TODO: 此处应该给那个页面的submit按钮做register操作
                    var doRegister = registerAction[key];
                    doRegister(form, obj);
                }).fail(function () {
                    log('失败了')
                });
                callback && callback();
            },
            error: function () {
                showAlert("网络出错，请检查你的网络和防火墙设置")
            },
        });
    });
}

function setDropdownListener(targetObj) {
    targetObj.on('click', '.dropdown-menu li a', function () {
        var target = $(this).html();
        //Adds active class to selected item
        $(this).parents('.dropdown-menu').find('li').removeClass('active');
        $(this).parent('li').addClass('active');
        //Displays selected text on dropdown-toggle button
        var $p = $(this).parents('.dropdown-select');
        $p.find('.dropdown-toggle').html(target + ' <span class="caret"></span>');
        $p.find('input[type=hidden]').val(target);
    });
}

/**
 * 注册一个提交表单事件
 * @param targetObj 注册点击事件的目标
 * @param sender 用来指明ajax的目标地址，其含有一个submitUrl
 */
function setSubmitListener(targetObj, sender) {
    targetObj.click(function (e) {
        e.stopPropagation();
        e.preventDefault();
        var datas = form_datas();

        $.ajax({
            method: 'Post',
            url: sender.submitUrl,
            dataType: 'text',
            data: {'json': JSON.stringify(datas)},
            success: function (result) {
                var results = JSON.parse(result);
                // 对应返回的值做对应的操作弹窗提示
                var key = results['result'];
                var adapter = alert_dict[key];
                showAdaptAlert(adapter, config.delay_short, function () {
                });
            },
            error: function (result) {
                showAlert(lang('network_disconnect'));
            },
        })
    });
}

var registerAction = {
    'submit': function (form, obj) {
        var $button = form.find('button[type=submit]');
        var $dropdown = $('.dropdown-select');

        // 如果提交按钮存在，注册点击事件
        $button.length && setSubmitListener($button, obj);
        // 如果下拉菜单存在，注册点击事件
        $dropdown.length && setDropdownListener($dropdown);
    },
    'query': function (obj) {
        $.ajax({
            method: 'Get',
            url: obj.submitUrl,
            success: function (result) {

            },
            error: function () {
                showAlert(lang('network_disconnect'));
            },
        })
    },
};