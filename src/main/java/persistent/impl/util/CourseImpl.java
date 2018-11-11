package persistent.impl.util;

import persistent.dao.course.CourseDAO;
import persistent.pojo.course.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseImpl implements CourseDAO {


    @Override
    public List<Course> findCourses(Course course) {
        List<Course> list = new ArrayList<>();


        return list;
    }

    @Override
    public Course findCourse(Course course) {
        return null;
    }
}
