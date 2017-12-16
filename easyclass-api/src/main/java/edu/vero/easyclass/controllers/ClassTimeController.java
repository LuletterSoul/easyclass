package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.ClassTime;
import edu.vero.easyclass.domain.TeacherComment;
import edu.vero.easyclass.services.ClassTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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
        return null;
    }

    @GetMapping(value = "/{timeId}")
    public ResponseEntity<ClassTime> findClassTime(@PathVariable("timeId") Integer timeId)
    {
        return null;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<ClassTime>> findAllClassTimes()
    {
        return null;
    }
}
