package servlet.user;

import handle.user.RegisterHandle;
import pojo.user.User;
import servlet.pub.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/user/register")
public class RegisterServlet extends BaseServlet {

    protected void Handle(HttpServletRequest req, HttpServletResponse resp){
        String json = req.getParameter("user");
        User user = (User) getBeanFromJson(json, User.class);

        try {
            if(new RegisterHandle().register(user))
                resp.getWriter().print("success");
            else
                resp.getWriter().print("failure");
        }catch (Exception e){

        }
    }


}
