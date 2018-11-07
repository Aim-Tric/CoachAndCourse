package servlet;

import handle.LoginHandle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * 接收返回登录操作
 */

@WebServlet("/servlet/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

//        use json
//        String json =req.getParameter("json").replace("＂","\"");
//        System.out.println(json);


        String account = req.getParameter("username");
        String password = req.getParameter("password");
        if(new LoginHandle().confirm(account, password)){
            resp.getWriter().print("success");
        }else{
            resp.getWriter().print("error");
        }
    }
}
