package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Course;
import edu.vero.easyclass.domain.Question;
import edu.vero.easyclass.services.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(description = "课程查询业务")
@RestController
@RequestMapping(value = "/courses")
public class CourseController
{

    private CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService)
    {
        this.courseService = courseService;
    }

    @ApiOperation(value = "创建一门新课程（测试通过）")
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course)
    {
        return new ResponseEntity<>(courseService.createCourse(course), HttpStatus.CREATED);
    }

    @ApiOperation(value = "删除某门课程（测试通过）")
    @DeleteMapping(value = "/{courseId}")
    public ResponseEntity<Course> deleteCourse(@PathVariable("courseId") Integer courseId)
    {
        return new ResponseEntity<>(courseService.deleteCourse(courseId), HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "查找全部的课程（测试通过）")
    @GetMapping
    public ResponseEntity<List<Course>> findAll()
    {
        return new ResponseEntity<>(courseService.findAllCourse(), HttpStatus.OK);
    }

    @ApiOperation(value = "查找某门课程（测试通过）")
    @GetMapping(value = "/{courseId}")
    public ResponseEntity<Course> findCourse(@PathVariable("courseId") Integer courseId)
    {
        return new ResponseEntity<>(courseService.findCourseById(courseId), HttpStatus.OK);
    }

    @ApiOperation(value = "获得课程下的问题（测试通过）")
    @GetMapping(value = "/{courseId}/questions")
    public ResponseEntity<List<Question>> findQuestions(@PathVariable("courseId") Integer courseId)
    {
        return new ResponseEntity<>(courseService.findCourseQuestion(courseId), HttpStatus.OK);
    }
}
