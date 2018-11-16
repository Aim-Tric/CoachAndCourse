package service.course;

import commons.Utils;
import persistent.impl.CourseImpl;
import persistent.pojo.course.Course;
import service.pub.BaseService;

import java.util.AbstractMap;

public class AddCourseService extends BaseService {

    public String addCourse(String courseJson) {
        Course course = (Course) getBeanFromJson(courseJson, Course.class);
        CourseImpl impl = new CourseImpl();
        int key = impl.insertCourse(course);
        return Utils.getResult(key);
    }


}
