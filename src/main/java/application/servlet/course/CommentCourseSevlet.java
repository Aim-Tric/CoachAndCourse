package application.servlet.course;

import application.servlet.pub.BaseServlet;
import persistent.pojo.User;
import service.CourseService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/application/servlet/comment-course")
public class CommentCourseSevlet extends BaseServlet {
    @Override
    protected void Handle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        接收评论信息，以及user的id和课程的id
        String comment = req.getParameter("comment");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("CNC");
        String cid = req.getParameter("cid");
        CourseService cs = new CourseService();
        cs.doComment(comment, user.getId(), 1);
    }
}
