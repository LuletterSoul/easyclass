package edu.vero.easyclass.services.impl;

import edu.vero.easyclass.domain.Course;
import edu.vero.easyclass.domain.Question;
import edu.vero.easyclass.repositories.CourseJpaDao;
import edu.vero.easyclass.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  18:41 2017/12/16.
 * @since easyclass
 */

@Service
public class CourseServiceImpl implements CourseService {
    private CourseJpaDao courseJpaDao;

    @Autowired
    public void setCourseJpaDao(CourseJpaDao courseJpaDao) {
        this.courseJpaDao = courseJpaDao;
    }

    @Override
    public List<Course> findAllCourse() {
        return courseJpaDao.findAll();
    }

    @Override
    public Course findCourseById(Integer courseId) {
        return courseJpaDao.findOne(courseId);
    }

    @Override
    public List<Question> findCourseQuestion(Integer courseId) {
        return new ArrayList<Question>(courseJpaDao.findOne(courseId).getQuestions());
    }
}
