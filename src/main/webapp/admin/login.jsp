<%--
  Created by IntelliJ IDEA.
  User: BK
  Date: 11/11/2018
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/header.jsp" %>
<div class="container">
    <div class="form row panel">
        <div class="panel-body col-md-offset-3">
            <form class="form-horizontal col-md-9" id="login_form">
                <h3 class="form-title">登录</h3>
                <div id='alert-pw' class='alert alert-warning hidden'>
                    <a href='#' class='close' data-dismiss='alert'>&times;</a><strong>警告！</strong>
                    <span>账户或密码错误</span>
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <i class="fa fa-user fa-lg"></i>
                        <input class="form-control required" type="text" placeholder="用户名" id="username"
                               name="username" autofocus="autofocus" maxlength="20" required/>
                    </div>
                    <div class="form-group">
                        <i class="fa fa-lock fa-lg"></i>
                        <input class="form-control required" type="password" placeholder="密码" id="password"
                               name="password" maxlength="16" required/>
                    </div>
                    <div class="form-group">
                        <label class="checkbox-custom checkbox-default"><input type="checkbox" id="remenberme"
                                                                               name="rememberme"
                                                                               value="1"/><label
                                for="remenberme">记住我</label>
                        </label>
                    </div>
                    <div class="form-group col-md-offset-3 login-panel-button-group">
                        <button type="submit" class="btn btn-success" id="do-login" name="do-login">登录</button>
                        <%-- 跳转到注册页面失败，code405，方法不允许 --%>
                        <a href="register.jsp" class="btn btn-default">注册</a>
                    </div>
                </div>
            </form>

        </div>
    </div>

</div>
<script>
    /**
     * rules用于设定FormChecker，为表单制定输入规则
     * 期望的rules的样例，但目前不是这样的
     * @type {{username: {len: number[], msg: string}, password: {}}}
     */
    var rules = {
        username: {
            len: [2, 8],
            msg: '用户名必须在2到8个字符之间',
        },
        password: {}, // 最后的逗号也要写上
    }


    /**
     * option用于设定FormPatcher，
     *          规定表单要提交到哪里，
     *          设定单独不提交的表单项（可以做成多个不提交的表单项。
     * FormPatcher的第二个参数是，提交完成，响应成功之后调用的函数，
     *              一般用于根据返回值决定跳转页面或是提示错误。
     * @type {{formChecker: FormChecker, cancel: null, url: string}}
     */
    var option = {
        formChecker: new FormChecker(rules),
        cancel: null,
        url: '/application/servlet/user/login',
    }
    new FormPatcher(option, function () {
        var ret = JSON.parse(result)
        var key = ret['result_code']
        var adapter = alert_dict[key]
        showAdaptAlert({
            adapter: adapter,
            callback: function () {
                window.location.href = '/index.jsp'
            }
        })
    })


    /**
     * 这玩意要放到一个新的文件里面，并在header.jsp或者footer.jsp里引入他
     * FIXME: formchecker的check()没实现
     */
    class FormPatcher {
        constructor(builder, onClickCallback) {
            this.elem = builder
            this.formChecker = this.elem.formChecker
            this.registerButtonClickEvent(onClickCallback)
        }

        registerButtonClickEvent(callback) {
            var self = this
            $('[type="submit"]').click(function (e) {
                e.stopPropagation()
                toggleForm('form')
                this.formChecker.check();
                self.defaultAjax()
                callBack && callback()
            })
        }

        static defaultData() {
            return {json: JSON.stringify(form_datas())}
        }

        defaultAjax() {
            var o = this.elem
            $.ajax({
                type: o.type || o.method || 'get',
                dataType: o.dataType || 'text',
                data: o.data || FormPatcher.defaultData(),
                url: o.url,
                success: function (result) {
                    var callback = o.callback || o.success
                    callback(result)
                },
                error: function () {
                    showAdaptAlert({
                        msg: lang('network_disconnect'),
                        level: 'error'
                    })
                }
            })
        }

    }

</script>
<%@include file="../common/footer.jsp" %>