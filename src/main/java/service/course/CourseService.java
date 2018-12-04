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

    public String addCourse(String courseJson) {
        Course course = JSON.parseObject(courseJson, Course.class);
        int key = impl.insertCourse(course);
        return Utils.getResult(key);
    }

    public List<Course> searchCourses(int id, int page) {
        return impl.findCourses(id, page, Consts.MAXLIMIT);
    }

}
