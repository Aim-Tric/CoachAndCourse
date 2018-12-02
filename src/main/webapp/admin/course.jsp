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
    request.setAttribute("course", cs.findCourse(course));
%>
<div class="container">
    <%--<div class="row breadcrumb">--%>
    <%--<div class="col-md-8 col-md-offset-2">--%>
    <%--<ol class="breadcrumb">--%>
    <%--<li><a href="#">Home</a></li>--%>
    <%--<li><a href="#">Library</a></li>--%>
    <%--<li class="active">Data</li>--%>
    <%--</ol>--%>
    <%--</div>--%>
    <%--</div>--%>
    <div class="row">
        <div class="col-md-6 col-lg-12">
            <%--<div class="col-md-4 col-lg-4">--%>
            <%--<img alt="300x200" src="../common/img/thumbnail1.jpg" style="max-width: 200px">--%>
            <%--</div>--%>
            <div class="page-header col-md-12 col-lg-12">
                <h2>${course.name}</h2>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 col-lg-4">
            <img alt="300x200" src="../common/img/thumbnail1.jpg" style="max-width: 200px">
        </div>
        <div class="col-md-8 col-lg-8">
            <div class="row">
                <div class="well">
                    <p>${course.overview}&nbsp&nbsp<span class="label label-success">${course.status}</span></span></p>
                    <p>课程最大人数:${course.max_person}</p>
                    <p>开始时间:${course.start_time}</p>
                </div>
            </div>
            <div class="row">
                <!-- Single button -->
                <div class="btn-group">
                    <button type="button" class="btn btn-primary">
                        加入课程
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

