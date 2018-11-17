package persistent.dao;

import persistent.pojo.course.Course;

import java.util.List;

public interface CourseDAO {

    List<Course> findCourses(Course course);

    Course findCourse(Course course);

    int insertCourse(Course course);

    void updateCourse(Course course);

}
