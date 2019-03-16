package service.impl;

import org.apache.ibatis.session.SqlSession;
import persistent.mapper.CourseMapper;
import persistent.pojo.Course;
import service.CourseService;
import utils.MybatisUtils;

import java.util.List;

public class NormalCourseService implements CourseService {

    @Override
    public List<Course> getLatestCourses() {
        SqlSession session = MybatisUtils.getFactory().openSession();
        CourseMapper mapper = session.getMapper(CourseMapper.class);
        List<Course> list = mapper.getLatestCourses(1, 4);
        session.close();
        return list;
    }

    public List<Course> getIndividualCourses(Integer uid) {
        SqlSession session = MybatisUtils.getFactory().openSession();
        CourseMapper mapper = session.getMapper(CourseMapper.class);
        List<Course> list = mapper.findCoursesByUserId(uid, 1, 10);
        session.close();
        return list;
    }

}
