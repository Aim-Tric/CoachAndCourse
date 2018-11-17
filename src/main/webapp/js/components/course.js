// function initialCreateCourse() {
//     $('#submit-btn').click(function () {
//         $.ajax({
//             type: 'Get',
//             url: '../admin/course/my-course.jsp',
//             // }success: function (result) {
//                 // TODO:打包课程信息json
//                 showAlert("创建请求已提交，请等待管理员审核", 'success');
//             },
//             error: function () {
//                 showAlert("网络出错，请检查你的网络和防火墙设置", 'error');
//             },
//         })
//     })
// }
//
// function initiaMyCourse() {
//     $.ajax({
//         type: 'Get',
//         url: '../admin/course/my-course.jsp',
//         success: function (result) {
//             $('.template-inner').html(result)
//         },
//         error: function () {
//             showAlert("网络出错，请检查你的网络和防火墙设置")
//         },
//     })


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
        log('json:', datas)

        $.ajax({
            method: 'Post',
            url: sender.submitUrl,
            dataType: 'text',
            data: {'json': JSON.stringify(datas)},
            success: function (result) {
                log('result', result);
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