<%--
  Created by IntelliJ IDEA.
  User: BK
  Date: 11/11/2018
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-md-2 col-lg-3 hidden-xs hidden-sm hidden-md">
    <div class="panel panel-default">

        <div class="panel-body">
            <form class="form-horizontal" id="login_form">
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
                        <a href="admin/register.jsp" class="btn btn-default">注册</a>
                    </div>
                </div>
            </form>

        </div>
    </div>

</div>