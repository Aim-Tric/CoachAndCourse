package application.user;

import application.pub.BaseServlet;
import commons.data.Consts;
import persistent.pojo.user.User;
import service.user.RegisterService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/application/user/register")
public class RegisterServlet extends BaseServlet {

    protected void Handle(HttpServletRequest req, HttpServletResponse resp){
        String json = req.getParameter("user");
        RegisterService rs = new RegisterService();
        User user = (User) getBeanFromJson(json, User.class);
        try {
            if (rs.register(user))
                resp.getWriter().print(Consts.RESULT_OK);
            else
                resp.getWriter().print(Consts.RESULT_FAILED);
        }catch (Exception e){

        }
    }


}
