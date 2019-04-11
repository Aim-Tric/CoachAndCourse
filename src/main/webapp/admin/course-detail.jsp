<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="persistent.mapper.CourseMapper" %>
<%@ page import="persistent.pojo.Comment" %>
<%@ page import="persistent.pojo.Course" %>
<%@ page import="utils.MybatisUtils" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
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
    SqlSession sqlSession = MybatisUtils.getFactory().openSession();
    CourseMapper cs = sqlSession.getMapper(CourseMapper.class);
    String id = request.getParameter("id");
    Course c = cs.findCourseById(Integer.valueOf(id));
    Integer person = cs.getCurrentPerson(c.getId());
    String url = "/admin/login.jsp";
    if (isLogged) {
        url = String.format("/application/servlet/course?method=join&cid=%d&status=%s&sid=%d", c.getId(), c.getStatus(), user.getId());
        boolean inCourse = cs.inCourse(c.getId(), user.getId());
        request.setAttribute("inCourse", inCourse);
    }
    pageContext.setAttribute("url", url);
    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
    request.setAttribute("start_time", format.format(c.getStart_time()));
    request.setAttribute("course", c);
    request.setAttribute("person", person);
    c = cs.findComments(c.getId());
    if (c != null) {
        List<Comment> cm = c.getComments();
        request.setAttribute("comments", cm);
    }
%>
<div class="container">
    <div class="row">
        <div class="col-md-12 col-lg-12">
            <ol class="breadcrumb">
                <li><a href="../index.jsp">首页</a></li>
                <li><a href="#">${course.type}</a></li>
                <li>${course.name}</li>
            </ol>
        </div>
        <div class="col-md-3 col-lg-3">
            <img alt="300x200" src="../common/img/thumbnail1.jpg" class="img-thumbnail">
        </div>
        <div class="col-md-8 col-lg-8">
            <div class="row">
                <div class="well">
                    <strong>${course.name}&nbsp&nbsp<span class="label label-success">${course.status}</span></strong>
                    <p>
                        ${course.overview}
                    </p>
                    <p>课程最大人数:${course.max_person}</p>
                    <p>开始时间:${start_time}</p>
                </div>
            </div>
            <div class="row">
                <div class="btn-group">
                    <button type="button" class="btn btn-primary">
                        <a href="${url}"><%
                            Object inCourse = request.getAttribute("inCourse");
                            if (inCourse != null && (boolean) inCourse) {%>
                            已加入课程
                            <%} else {%>
                            加入课程
                            <%}%></a>
                    </button>
                    <button type="button" class="btn">
                        咨询
                    </button>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <h1>课程评论</h1>
        <div class="col-md-12 col-lg-12">
            <%if (inCourse != null && (boolean) inCourse) {%>
            <div>
                <label for="comment">评论</label>
            </div>
            <div>
                <form>
                    <textarea name="comment" id="comment" style="width: 80%;" rows="5"></textarea>
                    <button id="do-comment" type="button" class="btn btn-primary">提交</button>
                </form>
            </div>
            <%} else {%>
            <span>登录后才能进行评论<a href="login.jsp">登录</a>或<a href="register.jsp">注册</a></span>
            <%}%>
        </div>
        <div class="comment-content">
            <c:if test="${comments != null}">
                <c:forEach items="${comments}" var="comment" end="${comments.size()}">
                    <div class="comment-block">
                        <div class="user">
                            <img class="user-avatar" src="../common/img/thumbnail1.jpg" alt="" width="64px">
                            <div class="user-name">
                                    ${comment.user.nickname}
                            </div>
                        </div>
                        <div class="comment">
                            <div>${comment.comment}</div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test="${comments == null}">
                <div>
                    该课程暂无评论
                </div>
            </c:if>
        </div>

    </div>
</div>

<script>
    $(function () {
        console.log()
        $('#do-comment').on('click', function () {
            let c = $('#comment').val();
            $.ajax({
                url: '../application/servlet/course',
                type: 'POST',
                data: {method: "comment",comment: c, cid: ${course.id}},
                success: function (result) {
                    if (result === 'true') {
                        let tmp = '<div class="comment-block">\n' +
                            '                        <div class="user">\n' +
                            '                            <img class="user-avatar" src="../common/img/thumbnail1.jpg" alt="" width="64px">\n' +
                            '                            <div class="user-name">\n' +
                            '                                    <%=user.getNickname()%>\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                        <div class="comment">\n' +
                            '                            <div>' + c + '</div>\n' +
                            '                        </div>\n' +
                            '                    </div>';
                        $('.comment-content').append(tmp);
                        $('#comment').val("");
                    } else {
                        alert("评论出错")
                    }
                },
                error: function () {

                }
            })
        })
    })
</script>

<%@include file="../common/footer.jsp" %>

