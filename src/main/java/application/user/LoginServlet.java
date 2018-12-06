package application.user;

import application.servlet.pub.BaseServlet;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import commons.data.Consts;
import persistent.pojo.user.User;
import service.user.LoginService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


/**
 * 接收返回登录操作
 */

@WebServlet("/application/user/login")
public class LoginServlet extends BaseServlet {

    protected void Handle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        User user;
        String json = req.getParameter("json");
        // 验证是用户名登录还是邮箱登录
        json = LoginService.changeToEmail(json); // 如果他是用email登录，才改变用户名为email
        user = JSON.parseObject(json, User.class);
        // 密码错误，直接跳出
        String result = LoginService.verify(user);
        if (!result.equals(Consts.RESULT_OK)) {
            return;
        }


        // 登录成功，从数据库取正确的用户信息
        HashMap<String, String> retMap = new HashMap<>();
        retMap.put("result", result);
        user = LoginService.findUser(user);
        retMap.put("nickname", user.getNickname());
        System.out.println("0x1101 JSONObject.toJSON(retMap) = " + JSONObject.toJSON(retMap));
        resp.getWriter().print(JSONObject.toJSON(retMap));

        // 数据预处理与存储
        HttpSession session = req.getSession();
        HashMap<String, String> map = new HashMap<>();
        map.put("CNCSID", session.getId());
        map.put("USERID", String.valueOf(user.getId()));
        session.setAttribute("nickname", user.getNickname());

        // 添加到Cookies
        Cookie ck;
        Set<HashMap.Entry<String, String>> entrySet = map.entrySet();
        Iterator<HashMap.Entry<String, String>> iter = entrySet.iterator();
        while (iter.hasNext()) {
            HashMap.Entry<String, String> entry = iter.next();
            ck = new Cookie(entry.getKey(), entry.getValue());
            ck.setMaxAge(Consts.COOKIE_EXPIRED_SEC);
            ck.setPath("/");
            resp.addCookie(ck);
        }

    }

}
