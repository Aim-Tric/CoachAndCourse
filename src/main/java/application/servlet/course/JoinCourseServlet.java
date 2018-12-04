package application.servlet.course;

import application.servlet.pub.BaseServlet;
import persistent.pojo.course.Course;
import persistent.pojo.user.User;
import service.course.CourseService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/application/servlet/course/joinCourse")
public class JoinCourseServlet extends BaseServlet {

    /**
     * 处理加入课程
     * 课程状态是'报名中'才执行加入
     */
    @Override
    protected void Handle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Course course = (Course) req.getAttribute("course");
        if ("报名中".equals(course.getStatus())) {
            User stu = (User) req.getSession().getAttribute("CNC");
            String ret = new CourseService().joinCourse((int) course.getId(), (int) stu.getId());
            responseRequest(resp, ret);
        }
    }

}
