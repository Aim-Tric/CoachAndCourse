package service.course;

import com.alibaba.fastjson.JSON;
import commons.Utils;
import commons.data.Consts;
import persistent.impl.CourseImpl;
import persistent.pojo.course.Course;

import java.util.List;


public class CourseService {
    CourseImpl impl;

    public CourseService(){
        impl = new CourseImpl();
    }

    /**
     * 新建课程
     * 收到包含课程信息的json，转换成Javabean，将其插入到数据库中
     *
     * @param courseJson 传入一个课程的数据
     * @return 返回插入课程的结果
     */
    public String addCourse(String courseJson) {
        Course course = JSON.parseObject(courseJson, Course.class);
        int key = impl.insertCourse(course);
        return Utils.getResult(key);
    }

    /**
     * 加入课程
     *
     * @param course_id 课程id
     * @param stu_id    学生id
     * @return 返回加入课程结果返回对应的结果
     */
    public String joinCourse(int course_id, int stu_id) {
        int key = impl.joinCourse(course_id, stu_id);
        return Utils.getResult(key);
    }

    /**
     * 查看个人课程
     * @param id 个人id，根据个人id查加入的课程id
     * @param page 页码数，进行分页查找
     * @return 返回当前页码能放下的所有课程
     */
    public List<Course> searchCourses(int id, int page) {
        return impl.findCourses(id, page, Consts.MAXLIMIT);
    }

}
