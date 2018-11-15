package persistent.dao.course;

import persistent.pojo.course.Course;

import java.util.List;

public interface CourseDAO {

    List<Course> findCourses(Course course);

    Course findCourse(Course course);

    String insertCourse(Course course);

    void updateCourse(Course course);

}
