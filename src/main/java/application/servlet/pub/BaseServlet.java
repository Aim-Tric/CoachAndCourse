package application.servlet.pub;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {


    private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Handle(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    protected abstract void Handle(HttpServletRequest req, HttpServletResponse resp) throws IOException;

    protected void responseRequest(HttpServletResponse response, String str) {
        try {
            PrintWriter out = response.getWriter();
            out.print(str);
        } catch (IOException ioe) {
            System.out.println("LoginServlet.responseRequest, 发生了 IOE");
            ioe.printStackTrace();
        }
    }

}
