package persistent.dao;

import org.apache.ibatis.annotations.Param;
import persistent.pojo.course.Course;

import java.util.List;

public interface CourseDAO {

    List<Course> findCourses(Course course, @Param("start") int start, @Param("maxLimit") int maxLimit);

    Course findCourse(Course course);

    int insertCourse(Course course);

    void updateCourse(Course course);

}
