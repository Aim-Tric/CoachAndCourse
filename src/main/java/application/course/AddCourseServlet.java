package application.course;

import application.pub.BaseServlet;
import service.course.CourseService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/application/course/add-course")
public class AddCourseServlet extends BaseServlet {

    @Override
    protected void Handle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String json = req.getParameter("json");
        // TODO:传进来的课程信息，先存表中待审核
        String ret = new CourseService().addCourse(json);
        resp.getWriter().print(ret);
    }
}
