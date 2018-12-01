package application.servlet.course;

import application.servlet.pub.BaseServlet;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import persistent.pojo.course.Course;
import persistent.pojo.user.User;
import service.course.CourseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 处理查询个人所加入的课程的servlet
 */
public class SearchCoursesServlet extends BaseServlet {

    @Override
    protected void Handle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // json在这里拿到的应该为当前的页码数
        String json = req.getParameter("json");

        // 开始查询课程
        CourseService cs = new CourseService();
        //先拿到当前的用户信息
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("CNC");
        int page = Integer.valueOf(json);
        // 根据用户信息查询相关课程，并根据页码实现分页功能
        List<Course> list = cs.searchCourses((int) user.getId(), page);
        //将查询结果转成json对象并response回到前端
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
}
