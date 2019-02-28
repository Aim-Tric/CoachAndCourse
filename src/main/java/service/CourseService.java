package service;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import persistent.mapper.CourseMapper;
import persistent.pojo.Comment;
import persistent.pojo.User;
import utils.MybatisUtils;
import utils.Utils;
import utils.data.Consts;
import persistent.pojo.Course;

import java.util.Date;
import java.util.List;


public class CourseService {
    private SqlSession session;

    /**
     * 新建课程
     * 收到包含课程信息的json，转换成Javabean，将其插入到数据库中
     *
     * @param courseJson 传入一个课程的json数据
     * @return 返回插入课程的结果
     */
    public String addCourse(String courseJson) {
        session = MybatisUtils.getFactory().openSession();
        CourseMapper mapper = session.getMapper(CourseMapper.class);
        Course course = JSON.parseObject(courseJson, Course.class);
        int key = mapper.insertCourse(course);
        session.close();
        return Utils.getResult(key);
    }

    /**
     * 加入课程
     *
     * @param course_id 课程id
     * @param stu_id    学生id
     * @return 返回加入课程结果返回对应的结果
     */
    public String joinCourse(Integer course_id, Integer stu_id) {
        session = MybatisUtils.getFactory().openSession();
        CourseMapper mapper = session.getMapper(CourseMapper.class);
        int key = mapper.joinCourse(course_id, stu_id);
        session.commit();
        session.close();
        return Utils.getResult(key);
    }

    public Course courseDetail(Integer id) {
        session = MybatisUtils.getFactory().openSession();
        CourseMapper mapper = session.getMapper(CourseMapper.class);
        Course c = mapper.findCourseById(id);
        session.close();
        return c;
    }

    /**
     * 查看个人课程
     *
     * @param id   个人id，根据个人id查加入的课程id
     * @param page 页码数，进行分页查找
     * @return 返回当前页码能放下的所有课程
     */
    public List<Course> searchCourses(Integer id, int page) {
        session = MybatisUtils.getFactory().openSession();
        CourseMapper mapper = session.getMapper(CourseMapper.class);
        List<Course> list = mapper.findCoursesByUserId(id, page, Consts.MAXLIMIT);
        session.close();
        return list;
    }

    public Course getComments(Integer id) {
        SqlSession session = MybatisUtils.getFactory().openSession();
        CourseMapper mapper = session.getMapper(CourseMapper.class);
        Course course = mapper.findComments(id);
        session.close();
        return course;
    }

    public boolean doComment(String comment, Integer uid, Integer cid) {
        boolean ret = true;
        SqlSession session = MybatisUtils.getFactory().openSession();
        CourseMapper mapper = session.getMapper(CourseMapper.class);
        try {
            User u = new User();
            u.setId(uid);
            Comment cm = new Comment(u, null, comment, null);
            mapper.doComment(cm, cid);
        } catch (Exception e) {
            ret = false;
        }
        session.commit();
        session.close();
        return ret;
    }

}
