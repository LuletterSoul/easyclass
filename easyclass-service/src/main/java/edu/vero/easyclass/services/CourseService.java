package edu.vero.easyclass.services;


import edu.vero.easyclass.domain.Course;
import edu.vero.easyclass.domain.Question;

import java.util.List;


public interface CourseService
{
    List<Course> findAllCourse();

    Course findCourseById(Integer courseId);

    List<Question> findCourseQuestion(Integer courseId);

    Course createCourse(Course course);

    Course deleteCourse(Integer courseId);
}
