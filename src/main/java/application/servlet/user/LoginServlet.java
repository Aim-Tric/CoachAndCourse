package application.servlet.user;

import application.servlet.pub.BaseServlet;
import commons.data.Consts;
import net.sf.json.JSONObject;
import persistent.pojo.user.User;
import service.user.LoginService;
import service.utils.UtilService;

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

@WebServlet("/application/servlet/user/login")
public class LoginServlet extends BaseServlet {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private boolean isLoginSuccess;
    private User user;
    private String status, result;

    protected void Handle(HttpServletRequest req, HttpServletResponse resp) {
        onCreate(req, resp);
        // 处理登录，密码正确时，isLogged就会为true
        loginHandle();

//        将登陆信息存入session中
        if (isLoginSuccess) {
            dataBuild();
        }
        responseRequest();
    }

    private void responseRequest() {
        try {
            PrintWriter out = response.getWriter();
            out.print(status);
        } catch (IOException ioe) {
            System.out.println("LoginServlet.responseRequest, 发生了 IOE");
            ioe.printStackTrace();
        }
    }

    private void dataBuild() {
        HashMap<String, String> returnMap = new HashMap<>();
        user = LoginService.findUser(user);
        returnMap.put("result_code", result);
        returnMap.put("nickname", user.getNickname());
        System.out.println();
        JSONObject ret = JSONObject.fromObject(returnMap);
        status = ret.toString();

        // 数据预处理与存储
        request.getSession().setAttribute("CNC", user);
        HashMap<String, String> map = new HashMap<>();
        map.put("CNCID", String.valueOf(user.getUsername().hashCode()));
        // 添加到Cookies
        addCookiesAndSessionByMap(map);

    }

    private void loginHandle() {
        String json = request.getParameter("json");

        // 验证是用户名登录还是邮箱登录
        json = LoginService.changeToEmail(json); // 如果他是用email登录，才改变用户名为email
        user = (User) UtilService.getBeanFromJson(json, User.class);
        // 密码错误，直接跳出
        result = LoginService.verify(user);
        if (result.equals(Consts.RESULT_OK)) {
            isLoginSuccess = true;
            return;
        }
    }

    private void onCreate(HttpServletRequest req, HttpServletResponse resp) {
        request = req;
        response = resp;
    }

    private void addCookiesAndSessionByMap(HashMap<String, String> map) {
        Cookie ck;
        for (HashMap.Entry<String, String> entry : map.entrySet()) {
            ck = new Cookie(entry.getKey(), entry.getValue());
            ck.setMaxAge(Consts.COOKIE_EXPIRED_SEC);
            ck.setPath("/");
            request.getSession().setAttribute(entry.getKey(), entry.getValue());
            response.addCookie(ck);
        }

    }


}
