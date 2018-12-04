package application.servlet.user;

import application.servlet.pub.BaseServlet;
import commons.DataTransferer;
import commons.data.Consts;
import net.sf.json.JSONObject;
import persistent.pojo.user.User;
import service.user.LoginService;

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

    private HttpServletRequest request;
    private HttpServletResponse response;
    private boolean isLoginSuccess;
    private User user;
    private String status, result;
    DataTransferer transferer;

    protected void Handle(HttpServletRequest req, HttpServletResponse resp) {
        synchronized (this) {
            onCreate(req, resp);
            // 处理登录，密码正确时，isLogged就会为true
            loginHandle();
//        将登陆信息存入session中

            if (isLoginSuccess) {
                dataBuild();
            }
            System.out.println(user);
            responseRequest(response, status);
        }

    }


    private void dataBuild() {
        HttpSession session = request.getSession();
        HashMap<String, String> returnMap = new HashMap<String, String>();
        user = LoginService.findUser(user);
        returnMap.put("result_code", result);
        returnMap.put("nickname", user.getNickname());
        JSONObject ret = JSONObject.fromObject(returnMap);
        status = ret.toString();
        // 数据预处理与存储
        session.setAttribute("CNC", user);
        session.setAttribute("INFO", "true");
        session.setAttribute("ROLE", user.getRole());
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("CNCID", String.valueOf(user.getUsername().hashCode()));
        // 添加到Cookies
        addCookiesAndSessionByMap(map);

    }

    private void loginHandle() {
        String json = request.getParameter("json");
        LoginService.login(json);
        transferer = DataTransferer.getInstance();
        // TODO:需要改进此数据传输方式
        user = (User) transferer.getData("user");
        result = (String) transferer.getData("result");
        // 密码错误，直接跳出
        if (Consts.RESULT_OK.equals(result)) {
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
