package application.user;

import application.pub.BaseServlet;
import commons.data.Consts;
import net.sf.json.JSONObject;
import persistent.pojo.user.User;
import service.user.LoginService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;


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
        String result = LoginService.verify(user);
        HashMap<String, String> retMap = new HashMap<>();
        retMap.put("result", result);
        JSONObject ret = JSONObject.fromObject(retMap);
        // 密码错误，直接跳出
        if (!result.equals(Consts.RESULT_OK)) {
            return;
        }
        // 登录成功，从数据库取正确的用户信息
        user = LoginService.findUser(user);

        retMap.put("nickname", user.getNickname());
        ret = JSONObject.fromObject(retMap);
        // 数据预处理与存储
        HashMap<String, String> map = new HashMap<>();
        map.put("CNCSID", req.getSession().getId());
        map.put("USERID", user.getId() + "");
        req.getSession().setAttribute("nickname", user.getNickname());
        for (HashMap.Entry<String, String> entry: map.entrySet()) {
            Cookie ck = new Cookie(entry.getKey(), entry.getValue());
            ck.setMaxAge(Consts.COOKIE_EXPIRED_SEC);
            ck.setPath("/");
            resp.addCookie(ck);
        }
        resp.getWriter().print(ret);
    }

}
