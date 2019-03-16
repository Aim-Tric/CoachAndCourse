package application.servlet.course;

import application.servlet.pub.BaseServlet;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import persistent.pojo.Course;
import persistent.pojo.User;
import service.impl.CourseServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 处理查询个人所加入的课程的servlet
 */
@WebServlet("/application/servlet/course/my-course")
public class MyCoursesServlet extends BaseServlet {

    @Override
    protected void Handle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
}
