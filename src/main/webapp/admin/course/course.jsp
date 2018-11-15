<%--
  Created by IntelliJ IDEA.
  User: Aim-Trick
  Date: 2018/11/13
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="sidebar.jsp" %>
<% if (user.getId() == 1) { %>
<%@include file="student-list.jsp" %>
<% } else { %>

<% } %>
