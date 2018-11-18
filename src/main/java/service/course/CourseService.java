package service.course;

import commons.Utils;
import commons.data.Consts;
import persistent.impl.CourseImpl;
import persistent.pojo.course.Course;
import service.utils.UtilService;

import java.util.ArrayList;
import java.util.List;


public class CourseService {
    CourseImpl impl;
    Course course;


    public CourseService(){
        impl = new CourseImpl();

    }

    public String addCourse(String courseJson) {
        course = (Course) UtilService.getBeanFromJson(courseJson, Course.class);
        // FIXME: 待会删掉这个硬编码操作
        course.setTeaid(2);
        int key = impl.insertCourse(course);
        return Utils.getResult(key);
    }

    public List<Course> SearchCourses(int page){
        return impl.findCourses(course, page, Consts.MAXLIMIT);
    }


}
