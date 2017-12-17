package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Courseware;
import edu.vero.easyclass.services.CoursewareService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(description = "上课时间节点业务")
@RestController
@RequestMapping(value = "/courseware")
public class CoursewareController
{
    private CoursewareService coursewareService;

    @Autowired
    public void setCoursewareService(CoursewareService coursewareService)
    {
        this.coursewareService = coursewareService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Courseware>> findAllCoursewares()
    {
        return new ResponseEntity<>(coursewareService.findAllCourseWare(), HttpStatus.OK);
    }

    @GetMapping(value = "/{coursewareId}")
    public ResponseEntity<Courseware> findCourseware(@PathVariable("coursewareId") Integer coursewareId)
    {
        return new ResponseEntity<>(coursewareService.findCourseWare(coursewareId), HttpStatus.OK);
    }
}