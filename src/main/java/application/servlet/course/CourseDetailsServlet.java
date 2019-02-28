package application.servlet.course;

import application.servlet.pub.BaseServlet;
import persistent.pojo.Course;
import service.CourseService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/application/servlet/course/detail")
public class CourseDetailsServlet extends BaseServlet {

    @Override
    protected void Handle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取课程id
        Integer c_id = Integer.valueOf(req.getParameter("cid"));
        // 通过id查询更多课程详细信息
        CourseService cs = new CourseService();
        // 返还课程详细信息，并跳转至详细页面
        Course c = cs.courseDetail(c_id);
        resp.sendRedirect("/admin/course-detail.jsp");

    }
}
