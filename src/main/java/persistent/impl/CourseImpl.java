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

    @Override
    public void insertCourse(Course course) {
        try {
            session = SessionFactory.getFactory().openSession();
            CourseDAO mapper = session.getMapper(CourseDAO.class);
            mapper.insertCourse(course);
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCourse(Course course) {
        try {
            session = SessionFactory.getFactory().openSession();
            CourseDAO mapper = session.getMapper(CourseDAO.class);
            mapper.updateCourse(course);
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        CourseImpl i = new CourseImpl();
//        Course c = new Course();
//        c.setName("语文");
//        c.setOverview("大学语文");
//        c.setTeaid(1);
//        c.setType("中文");
//        i.updateCourse(c);
//    }
}
