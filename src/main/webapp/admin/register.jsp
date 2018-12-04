<%--
  Created by IntelliJ IDEA.
  User: BK
  Date: 10/31/2018
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../common/header.jsp" %>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="form row">
        <form class="form-horizontal col-md-offset-3" id="register_form">
            <div class="col-md-9">
                <h3 class="form-title">注册</h3>

                <div id='alert-pw' class='alert alert-warning hidden'>
                    <a href='#' class='close' data-dismiss='alert'>&times;</a>
                    <strong>警告！</strong> <span>账户或密码错误</span>
                </div>
                <div class="col-md-12">
                    <div class="form-group">

                        <i class="fa fa-user fa-lg"></i>
                        <input class="form-control required" type="text" placeholder="用户名(必填)" id="username"
                               name="username" required autofocus="autofocus" maxlength="20"/>
                    </div>
                    <div class="form-group">

                        <i class="fa fa-envelope fa-lg"></i>
                        <input class="form-control required" type="text" placeholder="邮箱(必填)" id="email"
                               name="email" maxlength="16"/>
                    </div>
                    <div class="form-group">

                        <i class="fa fa-overview fa-lg"></i>
                        <input class="form-control required" type="text" placeholder="昵称(必填)" id="nickname"
                               name="nickname" maxlength="16"/>
                    </div>
                    <div class="form-group">

                        <i class="fa fa-lock fa-lg"></i>
                        <input class="form-control required" type="password" placeholder="密码(必填)" id="password"
                               name="password" maxlength="16"/>
                    </div>
                    <div class="form-group">

                        <i class="fa fa-lock fa-lg"></i>
                        <input class="form-control required" type="password" placeholder="确认密码(必填)" id="password_again"
                               name="password_again" maxlength="16"/>
                    </div>
                    <div class="form-group">
                        <label class="checkbox-custom checkbox-default">
                            <input type="checkbox" id="accept-checkbox" value="1"/>
                            <label for="accept-checkbox">我已阅读并接受<a href="#">使用条约</a></label>
                        </label>
                    </div>
                    <div class="form-group col-md-offset-3 login-panel-button-group">
                        <button type="submit" class="btn btn-success" id="do-register" name="do-register">确认注册</button>
                        <a href="/index.jsp" class="btn btn-default" id="back" name="back">返回主页
                        </a>
                    </div>

                </div>
            </div>
        </form>
    </div>

</div>

<script>


    $('#do-register').click(function (e) {
        e.stopPropagation();
        e.preventDefault();
        var form = form_datas({
            handle: 'form',
            cancel: 'password_again',
        });


        /**
         * 1. 用户名密码不能为空
         * 2. 两次密码必须匹配
         * 3. 用户名密码,邮箱，必须符合规则
         */
        if (checkSpell()) {
            return;
        }
        $.ajax({
            type: 'POST',
            url: '/application/servlet/user/register',
            dataType: 'text',
            data: {'json': JSON.stringify(form)},
            success: function (result) {

                location.href = '/index.jsp'
            },
            error: function () {
                $('#showAlert-pw').removeClass("hidden").children('span').text("网络出错，请检查你的网络和防火墙设置");
            }
        });
    });
</script>

<%@include file="../common/footer.jsp" %>

