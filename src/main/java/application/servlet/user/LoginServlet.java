package application.servlet.user;

import application.servlet.pub.BaseServlet;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import service.UserService;
import utils.data.Consts;
import persistent.pojo.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;


/**
 * 完成登录操作，并将操作结果返回给前端
 */

@WebServlet("/application/servlet/user/login")
public class LoginServlet extends BaseServlet {
    private User user;
    private String result;

    protected void Handle(HttpServletRequest req, HttpServletResponse resp) {
        synchronized (this) {
            // 处理登录，密码正确时，isLogged就会为true
            if (doLogin(req)) {
                // 将登陆信息存入session中
                HashMap<String, String> map = dataBuild(req);
                // 添加到Cookies
                addCookiesAndSessionByMap(req, resp, map);
            }
            HashMap<String, String> returnMap = new HashMap<>();
            returnMap.put("result_code", result);
            returnMap.put("nickname", user.getNickname());

            String status = JSONObject.toJSONString(returnMap);
            responseRequest(resp, status);
        }

    }


    private HashMap<String, String> dataBuild(HttpServletRequest req) {

        HttpSession session = req.getSession();
        // 数据预处理与存储
        session.setAttribute("CNC", user);
        session.setAttribute("INFO", "true");
        session.setAttribute("ROLE", user.getRole());
        HashMap<String, String> map = new HashMap<>();
        map.put("CNCID", String.valueOf(user.getUsername().hashCode()));
        return map;

    }

    private Boolean doLogin(HttpServletRequest req) {
        String json = req.getParameter("json");
        boolean loginSuccess = false;
        UserService service = new UserService();
        result = service.login(json);
        user = service.findUser(JSON.parseObject(json, User.class));

        // 密码错误，直接跳出
        if (Consts.RESULT_OK.equals(result)) {
            loginSuccess = true;
        }
        return loginSuccess;
    }

    private void addCookiesAndSessionByMap(HttpServletRequest req, HttpServletResponse resp, HashMap<String, String> map) {
        Cookie ck;
        for (HashMap.Entry<String, String> entry : map.entrySet()) {
            ck = new Cookie(entry.getKey(), entry.getValue());
            ck.setMaxAge(Consts.COOKIE_EXPIRED_SEC);
            ck.setPath("/");
            req.getSession().setAttribute(entry.getKey(), entry.getValue());
            resp.addCookie(ck);
        }

    }


}
