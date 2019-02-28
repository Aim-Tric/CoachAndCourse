package persistent.mapper;

import org.apache.ibatis.annotations.Param;
import persistent.pojo.Comment;
import persistent.pojo.Course;

import java.io.IOException;
import java.util.List;

public interface CourseMapper {

    List<Course> findCoursesByUserId(@Param("id") Integer id, @Param("page") Integer page, @Param("max") Integer max);

    List<Course> findNewestCourses(@Param("page") Integer page, @Param("max") Integer max);

    Course findCourseById(Integer id);

    int insertCourse(Course course);

    Integer getCurrentPerson(Integer id);

    int joinCourse(@Param("c_id") Integer course_id, @Param("s_id") Integer stu_id);

    void updateCourse(Course course) throws IOException;

    Course findComments(Integer id);

    boolean inCourse(@Param("cid") Integer cid, @Param("sid") Integer sid);

    boolean doComment(@Param("c") Comment comment, @Param("cid") Integer cid);

}
