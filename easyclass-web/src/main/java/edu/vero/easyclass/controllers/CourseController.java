package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Course;
import edu.vero.easyclass.domain.Question;
import edu.vero.easyclass.services.CourseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(description = "上课时间节点业务")
@RestController
@RequestMapping(value = "courses")
public class CourseController
{

    private CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService)
    {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> findAll()
    {
        return new ResponseEntity<>(courseService.findAllCourse(), HttpStatus.OK);
    }

    @GetMapping(value = "/{courseId}")
    public ResponseEntity<Course> findCourse(@PathVariable("courseId") Integer courseId)
    {
        return new ResponseEntity<>(courseService.findCourseById(courseId),HttpStatus.OK);
    }

    @GetMapping(value = "/{courseId}/questions")
    public ResponseEntity<List<Question>> findQuestions(@PathVariable("courseId") Integer courseId)
    {
        return new ResponseEntity<>(courseService.findCourseQuestion(courseId),HttpStatus.OK);
    }
}
