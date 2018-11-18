<%--
  Created by IntelliJ IDEA.
  User: BK
  Date: 11/11/2018
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="persistent.pojo.user.User" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="service.user.LoginService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 在刚加载页面时调用此jsp
    boolean isLogged = false;

    // FIXME: 登录后刷新拿不到user，user为null
    User user = new User();
    HashMap<String, String> map = new HashMap<>();
    for (Cookie ck : request.getCookies()) {
        map.put(ck.getName(), ck.getValue());
    }

    /*
     * TODO:
     * 在数据库中找到CNCSID是否已存在
     * 存在则为已登录
     * 确认已登录后就不需要登录界面，并给出个人信息
     */
    try {
        String CNCSID = map.get("CNCSID");
        String id = map.get("USERID");
        if (CNCSID != null && id != null)
            isLogged = CNCSID.equals(session.getId());
        if (isLogged) {
            // FIXME: 改掉这个简单的登录处理
            user.setId(Integer.parseInt(id));
            user = LoginService.findUser(user);
        }
    } catch (NullPointerException e) {
        e.printStackTrace();
    }

%>