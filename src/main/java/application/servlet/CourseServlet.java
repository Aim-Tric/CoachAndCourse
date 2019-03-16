package application.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import persistent.pojo.Course;
import persistent.pojo.User;
import pub.BaseServlet;
import service.CourseService;
import service.impl.CourseServiceImpl;
import service.impl.NormalCourseService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/application/servlet/course")
public class CourseServlet extends BaseServlet {

    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String json = req.getParameter("json");
        User teacher = (User) req.getSession().getAttribute("CNC");
        String ret = new CourseServiceImpl().addCourse(json);
        resp.getWriter().print(ret);
    }

    public void comment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //        接收评论信息，以及user的id和课程的id
        String comment = req.getParameter("comment");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("CNC");
        Integer cid = Integer.valueOf(req.getParameter("cid"));
        CourseServiceImpl cs = new CourseServiceImpl();
        boolean success = cs.doComment(comment, user.getId(), cid);
        resp.getWriter().print(String.valueOf(success));
    }

    public void details(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取课程id
        Integer c_id = Integer.valueOf(req.getParameter("cid"));
        // 通过id查询更多课程详细信息
        CourseServiceImpl cs = new CourseServiceImpl();
        // 返还课程详细信息，并跳转至详细页面
        Course c = cs.courseDetail(c_id);
        resp.sendRedirect("/admin/course-detail.jsp");
    }

    public void join(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String status = req.getParameter("status");
        int cid = Integer.valueOf(req.getParameter("cid"));
        int sid = Integer.valueOf(req.getParameter("sid"));
//        检查是否已加入该课程
        if ("报名中".equals(status)) {
            String ret = new CourseServiceImpl().joinCourse(cid, sid);
            resp.getWriter().print(ret);
        }
    }

    public void personal(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // json在这里拿到的应该为当前的页码数
        String json = req.getParameter("json");
        // 开始查询课程
        CourseServiceImpl cs = new CourseServiceImpl();
        // 先拿到当前的用户信息
        HttpSession session = req.getSession();
//        TODO: session中存的应该是一个user的唯一标识信息，在需要的时候在此执行查询
        User user = (User) session.getAttribute("CNC");
//        int page = Integer.valueOf(json);
        int page = Integer.valueOf(json);
//        TODO: 根据用户信息查询相关课程，并根据页码实现分页功能
        System.out.println("before search");
        List<Course> list = cs.searchCourses(user.getId(), page);
        System.out.println("after search");
//         将查询结果转成json对象并response回到前端
//        TODO: 我们需要一个工具类来打包json数据返回
        JSONArray ja = new JSONArray();
        for (Course c : list) {
            JSONObject jo = new JSONObject();
            jo.put("id", c.getId());
            jo.put("name", c.getName());
            jo.put("overview", c.getOverview());
            ja.add(jo);
        }
        resp.getWriter().print(ja);
    }

    public void getLatestCourses(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        CourseService service = new NormalCourseService();
        List<Course> list = service.getLatestCourses();
        resp.getWriter().print(JSON.toJSONString(list));
    }

    public void individual(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        CourseService service = new NormalCourseService();
        User user = (User) req.getSession().getAttribute("CNC");
        List<Course> list = service.getIndividualCourses(user.getId());
        resp.getWriter().print(JSON.toJSONString(list));
    }

}
