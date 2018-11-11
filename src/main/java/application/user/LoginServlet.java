package application.user;

import application.pub.BaseServlet;
import commons.data.Consts;
import persistent.pojo.user.User;
import service.user.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 接收返回登录操作
 */

@WebServlet("/application/user/login")
public class LoginServlet extends BaseServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    protected void Handle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String json = req.getParameter("user");
        User user = (User) getBeanFromJson(json, User.class);
        boolean isOK = new LoginService().verify(user);
        resp.getWriter().print(isOK ? Consts.RESULT_OK : Consts.RESULT_FAILED);
        Cookie ck = new Cookie("CNCSD", req.getSession().getId());
        int minExpire = 3;
        ck.setMaxAge(60 * minExpire);
        resp.addCookie(ck);
    }
}
