package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.ClassTime;
import edu.vero.easyclass.domain.TeacherComment;
import edu.vero.easyclass.services.ClassTimeService;
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
@RequestMapping(value = "/class_time")
public class ClassTimeController
{
    private ClassTimeService classTimeService;

    @Autowired
    public void setClassTimeService(ClassTimeService classTimeService)
    {
        this.classTimeService = classTimeService;
    }

    @GetMapping(value = "/{timeId}/comment")
    public ResponseEntity<List<TeacherComment>> findAllTeacherComment(@PathVariable("timeId") Integer timeId)
    {
        return new ResponseEntity<>(classTimeService.findAllTeacherComment(timeId),
                HttpStatus.OK);
    }

    @GetMapping(value = "/{timeId}")
    public ResponseEntity<ClassTime> findClassTime(@PathVariable("timeId") Integer timeId)
    {
        return new ResponseEntity<>(classTimeService.findClassTime(timeId),
                HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<ClassTime>> findAllClassTimes()

    {
        return new ResponseEntity<>(classTimeService.findAllClassTimes(),
                HttpStatus.OK);
    }
}
