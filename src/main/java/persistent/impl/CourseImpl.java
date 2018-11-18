package persistent.impl;

import org.apache.ibatis.session.SqlSession;
import persistent.dao.CourseDAO;
import persistent.impl.pub.BaseImpl;
import persistent.impl.utils.SessionFactory;
import persistent.pojo.course.Course;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CourseImpl implements CourseDAO {
    private SqlSession session;

    @Override
    public List<Course> findCourses(Course course, int start, int maxLimit) {
        List<Course> courses = new ArrayList<>();
        try {
            session = SessionFactory.getFactory().openSession();
            CourseDAO mapper = session.getMapper(CourseDAO.class);
            courses = mapper.findCourses(course, start, maxLimit);
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
//        c.setName("插入课程");
//        c.setOverview("简介就是没有简介");
//        c.setTeaid(2);
//        c.setType("数学");
//        List<Course> clist = new ArrayList<>();
//        i.insertCourse(c);
//        clist = i.findCourses(c, 3, 6);
//        Iterator it = clist.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
//    }

}
