function initialCreateCourse() {
    $('#submit-btn').click(function () {
        $.ajax({
            type: 'Get',
            url: '../admin/course/my-course.jsp',
            success: function (result) {
                // TODO:打包课程信息json
                showAlert("创建请求已提交，请等待管理员审核", 'success');
            },
            error: function () {
                showAlert("网络出错，请检查你的网络和防火墙设置", 'error');
            },
        })
    })
}

function initiaMyCourse() {
    $.ajax({
        type: 'Get',
        url: '../admin/course/my-course.jsp',
        success: function (result) {
            $('.template-inner').html(result)
        },
        error: function () {
            showAlert("网络出错，请检查你的网络和防火墙设置")
        },
    })
}


var registerAction = {
    'submit': function (obj) {
        var arr = {};
        var $form = $('form');
        var form = $form.serializeArray();
        $.each(form, function () {
            arr[this.name] = this.value;
        });
        $.ajax({
            method: 'Post',
            url: obj.submitUrl,
            dataType: 'text',
            data: {'json': JSON.stringify(arr)},
            success: function (result) {
                var results = JSON.parse(result);
                // 对应返回的值做对应的操作弹窗提示
                var key = results['result'];
                var values = alert_dict[key];
                var msg = values[0];
                var level = values[1];
                showAlert(msg, level);
            },
            error: function () {
                showAlert("网络状态不好，请检查你的网络和防火墙设置");
            },
        })

    },
    'query': function (obj) {
        $.ajax({
            method: 'Get',
            url: obj.submitUrl,
            success: function (result) {

            },
            error: function () {
                showAlert("网络状态不好，请检查你的网络和防火墙设置");
            },
        })
    },
};