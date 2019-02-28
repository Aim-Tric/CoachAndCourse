package application.servlet.user;

import application.servlet.pub.BaseServlet;
import com.alibaba.fastjson.JSON;
import persistent.pojo.User;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/application/servlet/user/register")
public class RegisterServlet extends BaseServlet {

    protected void Handle(HttpServletRequest req, HttpServletResponse resp) {
        String json = req.getParameter("json");
        UserService service = new UserService();
        User user = JSON.parseObject(json, User.class);
        responseRequest(resp, service.register(user));
    }

}
