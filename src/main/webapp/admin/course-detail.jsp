<%@ page import="persistent.impl.CourseImpl" %>
<%@ page import="persistent.pojo.course.Course" %>
<%--
  Created by IntelliJ IDEA.
  User: Aim-Trick
  Date: 2018/11/13
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/header.jsp" %>
<%
    CourseImpl cs = new CourseImpl();
    Course course = new Course();
    String id = request.getParameter("id");
    course.setId(Integer.valueOf(id));
    request.setAttribute("detail", cs.findCourse(course));
%>
<div class="container">
    <div class="row">
        <div class="col-md-12 col-lg-12">
            <ol class="breadcrumb">
                <li><a href="#">首页</a></li>
                <li>${detail.type}</li>
            </ol>
        </div>
        <div class="col-md-4 col-lg-4">
            <img alt="300x200" src="../common/img/thumbnail1.jpg" class="img-thumbnail">
        </div>
        <div class="col-md-8 col-lg-8">
            <div class="row">
                <div class="well">
                    <strong>${detail.name}&nbsp&nbsp<span class="label label-success">${detail.status}</span></strong>
                    <p>
                        ${detail.overview}
                    </p>
                    <p>课程最大人数:${detail.max_person}</p>
                    <p>开始时间:${detail.start_time}</p>
                </div>
            </div>
            <div class="row">
                <div class="btn-group">
                    <button type="button" class="btn btn-primary">
                        <%--TODO:检查是否已加入该课程--%>
                        <a href="../application/servlet/course/joinCourse?cid=${detail.id}&status=${detail.status}&sid=<%=user.getId()%>">加入课程</a>
                    </button>
                    <button type="button" class="btn">
                        咨询
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="../common/footer.jsp" %>

