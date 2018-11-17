package service.course;

import commons.Utils;
import persistent.impl.CourseImpl;
import persistent.pojo.course.Course;
import service.pub.BaseService;

public class AddCourseService extends BaseService {

    public String addCourse(String courseJson) {
        Course course = (Course) getBeanFromJson(courseJson, Course.class);
        CourseImpl impl = new CourseImpl();
        int key = impl.insertCourse(course);
        // FIXME: 永远都是-1
        return Utils.getResult(key);
    }


}
