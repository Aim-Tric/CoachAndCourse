function initialSidebar() {

    var keys = [];
    for (var k in sidebar_list) {
        keys.push(k);
    }

    for (let i = 0; i < keys.length; i++) {
        var obj = sidebar_list[keys[i]];
        addClickListener(obj);
    }

    function addClickListener(obj) {
        $(obj.id).click(function (e) {
            $.ajax({
                type: 'Get',
                url: obj.url,
                success: function (result) {
                    $('.template-inner').html(result);
                    // TODO:为提交按钮添加ajax
                    // 这里registerAction[obj.type]拿到的是一个函数
                    // 将调用这个函数，参数为obj
                    var key = obj.type;
                    var doRegister = registerAction[key];
                    doRegister(obj);
                },
                error: function () {
                    showAlert("网络出错，请检查你的网络和防火墙设置")
                },
            });
        });
    }


}
