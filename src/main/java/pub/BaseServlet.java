package pub;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        if (method != null) {
            execute(method, req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    private void execute(String method, HttpServletRequest req, HttpServletResponse resp) {
        try {
            //通过反射调用对应的方法，通过“this”获取class对象
            Class clazz = this.getClass();
            //通过class对象和方法名获取方法对象
            Method m = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            //通过反射机制调用方法
            m.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
