package application.servlet.course;

import application.servlet.pub.BaseServlet;
import service.CourseService;

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
        String status = req.getParameter("status");
        int cid = Integer.valueOf(req.getParameter("cid"));
        int sid = Integer.valueOf(req.getParameter("sid"));
//        检查是否已加入该课程
        if ("报名中".equals(status)) {
            String ret = new CourseService().joinCourse(cid, sid);
            responseRequest(resp, ret);

        }
    }

}
