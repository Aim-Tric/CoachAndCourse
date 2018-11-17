package service.course;

import commons.Utils;
import persistent.impl.CourseImpl;
import persistent.pojo.course.Course;
import service.utils.UtilService;

public class AddCourseService {

    public String addCourse(String courseJson) {
        Course course = (Course) UtilService.getBeanFromJson(courseJson, Course.class);
        CourseImpl impl = new CourseImpl();
        int key = impl.insertCourse(course);
        return Utils.getResult(key);
    }


}
