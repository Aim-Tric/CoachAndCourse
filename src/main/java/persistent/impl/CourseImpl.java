package persistent.impl;

import org.apache.ibatis.session.SqlSession;
import persistent.dao.course.CourseDAO;
import persistent.impl.util.SessionFactory;
import persistent.pojo.course.Course;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseImpl implements CourseDAO {
    private SqlSession session;

    @Override
    public List<Course> findCourses(Course course) {
        List<Course> courses = new ArrayList<>();
        try {
            session = SessionFactory.getFactory().openSession();
            CourseDAO mapper = session.getMapper(CourseDAO.class);
            courses = mapper.findCourses(course);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return courses;
    }

    @Override
    public Course findCourse(Course course) {
        Course c = null;
        try {
            session = SessionFactory.getFactory().openSession();
            CourseDAO mapper = session.getMapper(CourseDAO.class);
            c = mapper.findCourse(course);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return c;
    }
}
