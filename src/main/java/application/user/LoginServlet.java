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
import java.util.HashMap;
import java.util.Map;


/**
 * 接收返回登录操作
 */

@WebServlet("/application/user/login")
public class LoginServlet extends BaseServlet {

    protected void Handle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        User user;
        String json;
        json = req.getParameter("user");

        // 验证是用户名登录还是邮箱登录
        json = LoginService.ifIsEmail(json);
        user = (User) LoginService.getBeanFromJson(json, User.class);
//      FIXME user为NULL
        String result = LoginService.verify(user);
        out.print(result);

        // 登录后的数据预处理与存储
        if (!result.equals(Consts.RESULT_OK))
            return;

        HashMap<String, String> map = new HashMap<>();
        map.put("CNCSID", req.getSession().getId());
        map.put("USERID", user.getId() + "");
        for (HashMap.Entry<String, String> entry: map.entrySet()) {
            out.print("k:v = " +entry.getKey() + " " + entry.getValue());
            Cookie ck = new Cookie(entry.getKey(), entry.getValue());
            ck.setMaxAge(Consts.COOKIE_EXPIRED_SEC);
            ck.setPath("/");
            resp.addCookie(ck);
        }
    }

}
