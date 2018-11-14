package persistent.dao.course;

import persistent.pojo.course.Course;

import java.util.List;

public interface CourseDAO {

    List<Course> findCourses(Course course);

    Course findCourse(Course course);

    void insertCourse(Course course);

    void updateCourse(Course course);

}
