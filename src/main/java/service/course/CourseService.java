package service.course;

import commons.Utils;
import commons.data.Consts;
import persistent.impl.CourseImpl;
import persistent.pojo.course.Course;
import service.utils.UtilService;

import java.util.List;


public class CourseService {
    CourseImpl impl;

    public CourseService(){
        impl = new CourseImpl();
    }

    public String addCourse(String courseJson) {
        Course course = (Course) UtilService.getBeanFromJson(courseJson, Course.class);
        int key = impl.insertCourse(course);
        return Utils.getResult(key);
    }

    public List<Course> searchCourses(int id, int page) {
        return impl.findCourses(id, page, Consts.MAXLIMIT);
    }

}
