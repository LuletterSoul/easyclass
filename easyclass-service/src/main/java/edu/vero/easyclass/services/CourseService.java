package edu.vero.easyclass.services;

import edu.vero.easyclass.domain.Course;
import edu.vero.easyclass.domain.Question;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourse();
    Course findCourseById(String courseId);
    List<Question> findCourseQuestion(String courseId);
}
