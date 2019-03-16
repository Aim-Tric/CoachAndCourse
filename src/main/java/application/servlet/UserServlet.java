package application.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.istack.internal.NotNull;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import persistent.pojo.User;
import pub.BaseServlet;
import service.UserService;
import service.impl.NormalUserService;
import service.impl.UserServiceImpl;
import utils.data.Consts;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.util.HashMap;

@WebServlet("/application/servlet/user")
public class UserServlet extends BaseServlet {

    /**
     * 登录功能
     *
     * @param req  请求
     * @param resp 响应
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String json = req.getParameter("json");
        UserService service = new NormalUserService();
        User user = JSON.parseObject(json, User.class);
        user = service.login(user);
        String result = Consts.RESULT_OK;
        HashMap<String, String> returnMap = new HashMap<>();
        if (user == null) {
            result = Consts.RESULT_FAILED;
        } else {

            HttpSession session = req.getSession();
            // 数据预处理与存储
            session.setAttribute("CNC", user);
            session.setAttribute("INFO", "true");
            session.setAttribute("ROLE", user.getRole());
            HashMap<String, String> map = new HashMap<>();
            map.put("CNCID", String.valueOf(user.getUsername().hashCode()));
            Cookie ck;
            for (HashMap.Entry<String, String> entry : map.entrySet()) {
                ck = new Cookie(entry.getKey(), entry.getValue());
                ck.setMaxAge(Consts.COOKIE_EXPIRED_SEC);
                ck.setPath("/");
                req.getSession().setAttribute(entry.getKey(), entry.getValue());
                resp.addCookie(ck);
            }
            returnMap.put("nickname", user.getNickname());

        }
        returnMap.put("result_code", result);

        String status = JSONObject.toJSONString(returnMap);
        resp.getWriter().print(status);
    }

    public void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String json = req.getParameter("json");
        UserService service = new NormalUserService();
        User user = JSON.parseObject(json, User.class);
        String result = service.register(user);
        resp.getWriter().print(result);
    }

    public void getUserRole(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("CNC");
        resp.getWriter().print(user.getRole());
    }


}
