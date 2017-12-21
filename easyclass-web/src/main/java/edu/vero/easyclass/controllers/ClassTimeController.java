package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.ClassTime;
import edu.vero.easyclass.domain.ClassTimeComment;
import edu.vero.easyclass.services.ClassTimeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "/{timeId}/comments")
    public ResponseEntity<ClassTimeComment> saveClassComment(@RequestBody ClassTimeComment comment,
                                                             @PathVariable("timeId") Integer timeId)
    {
        return new ResponseEntity<>(classTimeService.savePerClassComment(timeId, comment),
            HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{timeId}/comments")
    public ResponseEntity<List<ClassTimeComment>> findAllClassComments(@PathVariable("timeId") Integer timeId)
    {
        return new ResponseEntity<>(classTimeService.findAllClassComments(timeId), HttpStatus.OK);
    }

    @GetMapping(value = "/{timeId}")
    public ResponseEntity<ClassTime> findClassTime(@PathVariable("timeId") Integer timeId)
    {
        return new ResponseEntity<>(classTimeService.findClassTime(timeId), HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<ClassTime>> findAllClassTimes()

    {
        return new ResponseEntity<>(classTimeService.findAllClassTimes(), HttpStatus.OK);
    }
    @PostMapping(value = "")
    public ResponseEntity<ClassTime> createClassTime(@RequestBody ClassTime classTime)

    {
        return new ResponseEntity<>(classTimeService.createClassTime(classTime), HttpStatus.CREATED);
    }
    @PutMapping(value = "")
    public ResponseEntity<ClassTime> updateClassTime(@RequestBody ClassTime classTime)

    {
        return new ResponseEntity<>(classTimeService.updateClassTime(classTime), HttpStatus.OK);
    }
    @DeleteMapping(value = "/{timeId}")
    public ResponseEntity<ClassTime> deleteClassTime(@PathVariable("timeId") Integer timeId)
    {
        return new ResponseEntity<>(classTimeService.deleteClassTime(timeId),
                HttpStatus.NO_CONTENT);
    }

}
