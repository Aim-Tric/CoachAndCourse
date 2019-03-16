package application.servlet.course;

import application.servlet.pub.BaseServlet;
import persistent.pojo.User;
import service.impl.CourseServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/application/servlet/comment-course")
public class CommentCourseServlet extends BaseServlet {

    @Override
    protected void Handle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        接收评论信息，以及user的id和课程的id
        String comment = req.getParameter("comment");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("CNC");
        Integer cid = Integer.valueOf(req.getParameter("cid"));
        CourseServiceImpl cs = new CourseServiceImpl();
        boolean success = cs.doComment(comment, user.getId(), cid);
        responseRequest(resp, String.valueOf(success));
    }
}
