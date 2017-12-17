package edu.vero.easyclass.controllers;

import edu.vero.easyclass.domain.Course;
import edu.vero.easyclass.domain.Question;
import edu.vero.easyclass.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="courses")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> findAll(){
        return null;
    }
    @GetMapping(value="/{courseId}")
    public ResponseEntity<Course> findCourse(@PathVariable("courseId") String courseId){
        return  null;
    }
    @GetMapping(value = "/{courseId}/questions")
    public RequestEntity<List<Question>> findQuestions(@PathVariable("courseId") String courseId){
        return null;
    }
}
