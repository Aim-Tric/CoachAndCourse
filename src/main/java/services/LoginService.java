package services;

import handle.LoginHandle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet/login")
public class LoginService extends HttpServlet {

    /**
     * 接收返回登录操作
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String account = req.getParameter("username");
        String password = req.getParameter("password");

        if(new LoginHandle().confirm(account, password)){
            resp.getWriter().write("登录成功");
        }else{
            resp.getWriter().write("登录失败");
        }

    }
}
