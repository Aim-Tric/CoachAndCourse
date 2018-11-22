<%--
  Created by IntelliJ IDEA.
  User: Aim-Trick
  Date: 2018/11/13
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/header.jsp" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-2 sidebar">
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
                            <a id="moments">
                                <div class="panel-body">
                                    个人空间
                                </div>
                            </a>
                            <a id="profile">
                                <div class="panel-body">
                                    公开资料
                                </div>
                            </a>
                            <a id="private">
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
                                <li><a id="new-course">
                                    <div class="panel-body">
                                        创建课程
                                    </div>
                                </a></li>
                                <li class="active"><a id="my-course">
                                    <div class="panel-body">
                                        已参加课程
                                    </div>
                                </a></li>
                                <li><a id="update-course">
                                    <div class="panel-body">
                                        修改课程
                                    </div>
                                </a></li>
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
                            <a href="">
                                <div class="panel-body">
                                    发布场所信息
                                </div>
                            </a>
                            <a href="">
                                <div class="panel-body">
                                    修改场所信息
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 template">
            <div class="template-inner">
                <%--<jsp:include page="/admin/course/my-course.jsp">--%>
                <%--<jsp:param name="page" value="1" />--%>
                <%--</jsp:include>--%>

            </div>

        </div>
    </div>
</div>