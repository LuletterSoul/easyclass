package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Courseware;
import io.swagger.annotations.Api;
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
    @GetMapping(value = "")
    public ResponseEntity<List<Courseware>> findAllCoursewares()
    {
        return null;
    }

    @GetMapping(value = "/{coursewareId}")
    public ResponseEntity<Courseware> findCourseware(@PathVariable("coursewareId") Integer coursewareId)
    {
        return null;
    }
}