package application.servlet.course;

import application.servlet.pub.BaseServlet;
import persistent.pojo.User;
import service.CourseService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/application/servlet/course/add-course")
public class AddCourseServlet extends BaseServlet {

    @Override
    protected void Handle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String json = req.getParameter("json");
        User teacher = (User) req.getSession().getAttribute("CNC");
        String ret = new CourseService().addCourse(json);
        resp.getWriter().print(ret);
    }
}
