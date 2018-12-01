package persistent.dao;

import org.apache.ibatis.annotations.Param;
import persistent.pojo.course.Course;

import java.util.Date;
import java.util.List;

public interface CourseDAO {

    List<Course> findCourses(@Param("id") int id, @Param("start") int start, @Param("maxLimit") int maxLimit);

    List<Course> findNewestCourses(@Param("date") Date date);

    Course findCourse(Course course);

    int insertCourse(Course course);

    void updateCourse(Course course);


}
