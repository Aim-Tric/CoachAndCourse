package persistent.impl;

import org.apache.ibatis.session.SqlSession;
import persistent.dao.CourseDAO;
import persistent.impl.pub.BaseImpl;
import persistent.impl.utils.SessionFactory;
import persistent.pojo.course.Course;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseImpl implements CourseDAO {
    private SqlSession session;

    @Override
    public List<Course> findCourses(int id, int page, int maxLimit) {
        List<Course> courses = new ArrayList<>();
        try {
            session = SessionFactory.getFactory().openSession();
            CourseDAO mapper = session.getMapper(CourseDAO.class);
            courses = mapper.findCourses(id, page, maxLimit);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return courses;
    }

    @Override
    public List<Course> findNewestCourses() {
        List<Course> courses = new ArrayList<>();
        try {
            session = SessionFactory.getFactory().openSession();
            CourseDAO mapper = session.getMapper(CourseDAO.class);
            courses = mapper.findNewestCourses();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            session.close();
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
        } catch (Exception e) {
            BaseImpl.catchCommunicationsException(e);
            BaseImpl.catchNullPointerException(e);
        } finally {
            session.close();
        }
        return c;
    }


    @Override
    public int insertCourse(Course course) {
        int ret;
        try {
            session = SessionFactory.getFactory().openSession();
            CourseDAO mapper = session.getMapper(CourseDAO.class);
            ret = mapper.insertCourse(course);
            session.commit();
        } catch (Exception e) {
            BaseImpl.catchCommunicationsException(e);
            ret = -1;
        } finally {
            session.close();
        }
        return ret;
    }

    @Override
    public int joinCourse(int course_id, int stu_id) {
        int ret;
        try {
            session = SessionFactory.getFactory().openSession();
            CourseDAO mapper = session.getMapper(CourseDAO.class);
            ret = mapper.joinCourse(course_id, stu_id);
            session.commit();
        } catch (Exception e) {
            BaseImpl.catchCommunicationsException(e);
            ret = -1;
        } finally {
            session.close();
        }
        return ret;
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
        } finally {
            session.close();
        }
    }

}
