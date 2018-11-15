package application.course;

import application.pub.BaseServlet;
import service.course.AddCourseService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/application/course/add-course")
public class AddCourseServlet extends BaseServlet {

    @Override
    protected void Handle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String json = req.getParameter("course");
        // TODO:传进来的课程信息，先由管理员审核，再完成数据库操作

        AddCourseService acs = new AddCourseService();
        String ret = acs.addCourse(json);
        resp.getWriter().print(ret);
    }
}
