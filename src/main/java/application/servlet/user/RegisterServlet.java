package application.servlet.user;

import application.servlet.pub.BaseServlet;
import com.alibaba.fastjson.JSON;
import persistent.pojo.user.User;
import service.user.RegisterService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/application/servlet/user/register")
public class RegisterServlet extends BaseServlet {

    protected void Handle(HttpServletRequest req, HttpServletResponse resp) {
        String json = req.getParameter("user");
        RegisterService rs = new RegisterService();
        User user = JSON.parseObject(json, User.class);
        try {
            resp.getWriter().print(rs.register(user));
        } catch (Exception e) {

        }
    }

}
