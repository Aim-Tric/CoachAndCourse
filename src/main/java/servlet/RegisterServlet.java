package servlet;

import handle.RegisterHandle;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

//        String json =req.getParameter("json").replace("＂","\"");
//        System.out.println("here");

        String username = req.getParameter("username");
        String sex = req.getParameter("sex");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        String email = req.getParameter("email");

        User user = new User(username, sex, password, nickname, email);

        if(new RegisterHandle().register(user))
            resp.getWriter().print("success");
        else
            resp.getWriter().print("failure");
    }


}
