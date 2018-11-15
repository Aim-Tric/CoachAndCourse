package service.course;

import commons.data.Consts;
import persistent.impl.CourseImpl;
import persistent.pojo.course.Course;
import service.pub.BaseService;

public class AddCourseService extends BaseService {

    public String addCourse(String courseJson) {
        String ret = Consts.RESULT_OK;
        Course course = (Course) getBeanFromJson(courseJson, Course.class);
        CourseImpl impl = new CourseImpl();
        return impl.insertCourse(course);
    }


}
