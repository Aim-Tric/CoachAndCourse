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
        String username = req.getParameter("username");
        String sex = req.getParameter("sex");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        String email = req.getParameter("email");

        User user = new User(username, sex, password, nickname, email);

        try {
            if(new RegisterHandle().register(user))
                resp.getWriter().print("success");
            else
                resp.getWriter().print("failure");
        }catch (Exception e){

        }
    }


}
