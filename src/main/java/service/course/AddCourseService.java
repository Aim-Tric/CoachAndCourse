package service.course;

import commons.Utils;
import persistent.impl.CourseImpl;
import persistent.pojo.course.Course;
import service.utils.UtilService;


public class AddCourseService extends BaseService {

    public String addCourse(String courseJson) {
        Course course = (Course) getBeanFromJson(courseJson, Course.class);
        // FIXME: 待会删掉这个硬编码操作
        course.setTeaid(2);
        CourseImpl impl = new CourseImpl();
        int key = impl.insertCourse(course);
        return Utils.getResult(key);
    }


}
