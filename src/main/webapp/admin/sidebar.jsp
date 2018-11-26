<%--
  Created by IntelliJ IDEA.
  User: Aim-Trick
  Date: 2018/11/13
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="nav nav-sidebar">
    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingOne">
                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                   aria-expanded="true" aria-controls="collapseOne">
                    <h4 class="panel-title">
                        个人
                    </h4>
                </a>
            </div>
            <div id="collapseOne" class="panel-collapse collapse " role="tabpanel"
                 aria-labelledby="headingOne">
                <a role="button" id="moments">
                    <div class="panel-body">
                        个人空间
                    </div>
                </a>
                <a role="button" id="profile">
                    <div class="panel-body">
                        公开资料
                    </div>
                </a>
                <a role="button" id="private">
                    <div class="panel-body">
                        私人资料
                    </div>
                </a>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingTwo">
                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"
                   aria-expanded="true" aria-controls="collapseTwo">
                    <h4 class="panel-title">
                        课程
                    </h4>
                </a>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse in" role="tabpanel"
                 aria-labelledby="headingTwo">
                <ul>
                    <%
                        User u = (User) session.getAttribute("CNC");
                        boolean isTeacher = "tea".equals(u.getRole());
                    %>
                    <li class="active"><a role="button" id="my-course">
                        <div class="panel-body">
                            我的课程
                        </div>
                    </a></li>
                    <% if (isTeacher) {%>
                    <li><a role="button" id="new-course">
                        <div class="panel-body">
                            创建课程
                        </div>
                    </a></li>
                    <li><a role="button" id="update-course">
                        <div class="panel-body">
                            修改课程
                        </div>
                    </a></li>
                    <%}%>
                </ul>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingThree">
                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree"
                   aria-expanded="true" aria-controls="collapseThree">
                    <h4 class="panel-title">
                        场所
                    </h4>
                </a>
            </div>
            <div id="collapseThree" class="panel-collapse collapse" role="tabpanel"
                 aria-labelledby="headingThree">
                <a role="button" href="">
                    <div class="panel-body">
                        发布场所信息
                    </div>
                </a>
                <a role="button" href="">
                    <div class="panel-body">
                        修改场所信息
                    </div>
                </a>
            </div>
        </div>
    </div>
</ul>
