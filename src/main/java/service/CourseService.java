package service;

import persistent.pojo.Course;

import java.util.List;

/**
 * 课程服务接口
 */
public interface CourseService {

    List<Course> getLatestCourses();

    List<Course> getIndividualCourses(Integer uid);

}
