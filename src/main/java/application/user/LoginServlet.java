package application.user;

import application.pub.BaseServlet;
import commons.data.Consts;
import persistent.pojo.user.User;
import service.user.LoginService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 接收返回登录操作
 */

@WebServlet("/application/user/login")
public class LoginServlet extends BaseServlet {

    protected void Handle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        Cookie ck;
        User user;
        String json;
        json = req.getParameter("user");

        // 验证是用户名登录还是邮箱登录
        json = LoginService.ifIsEmail(json);
        user = (User) LoginService.getBeanFromJson(json, User.class);
        String result = LoginService.verify(user);
        out.print(result);

        // 登录后的数据预处理与存储
        if (!result.equals(Consts.RESULT_OK))
            return;

        ck = new Cookie("CNCSID", req.getSession().getId());
        ck.setMaxAge(Consts.COOKIE_EXPIRED_SEC);
        ck.setPath("/");
        resp.addCookie(ck);
    }

}
