<%--
  Created by IntelliJ IDEA.
  User: BK
  Date: 10/31/2018
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"> <!-- for HTML5 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>中文</title>

    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
<div class="container">
    <div class="form row">
        <form class="form-horizontal col-md-offset-3" id="login_form">
            <h3 class="form-title">注册</h3>
            <div class="col-md-9">

                <div id='alert-pw' class='alert alert-warning hidden'>
                    <a href='#' class='close' data-dismiss='alert'>&times;</a>
                    <strong>警告！</strong> <span>账户或密码错误</span>
                </div>
                <div class="col-md-12">
                    <div class="form-group">

                        <i class="fa fa-user fa-lg"></i>
                        <input class="form-control required" type="text" placeholder="用户名" id="username"
                               name="username" autofocus="autofocus" maxlength="20"/>
                    </div>
                    <div class="form-group">

                        <i class="fa fa-lock fa-lg"></i>
                        <input class="form-control required" type="password" placeholder="密码" id="password"
                               name="password" maxlength="16"/>
                    </div>
                    <div class="form-group">

                        <i class="fa fa-lock fa-lg"></i>
                        <input class="form-control required" type="password" placeholder="确认密码" id="password_again"
                               name="password_again" maxlength="16"/>
                    </div>
                    <div class="form-group">
                        <label class="checkbox-custom checkbox-default">
                            <input type="checkbox" id="remenberme" name="rememberme" value="1"/>
                            <label for="remenberme">我已阅读并接受使用条约</label>
                        </label>
                    </div>
                    <div class="form-group col-md-offset-3 login-panel-button-group">
                        <button type="submit" class="btn btn-success" id="do-register" name="do-register">确认注册</button>
                        <button type="submit" class="btn btn-default" id="back" name="back">返回主页
                        </button>
                    </div>

                </div>
            </div>
        </form>
    </div>

</div>
</body>
</html>
