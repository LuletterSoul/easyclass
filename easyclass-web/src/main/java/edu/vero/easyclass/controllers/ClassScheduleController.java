package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.*;
import edu.vero.easyclass.services.ClassScheduleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(description = "学生课表业务")
@RequestMapping(value = "/schedules")
public class ClassScheduleController
{

    private ClassScheduleService scheduleService;

    @Autowired
    public void setScheduleService(ClassScheduleService scheduleService)
    {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public ResponseEntity<List<ClassSchedule>> findAllSchedule()
    {
        return null;
    }

    // 一次上传一个作业
    @PostMapping(value = "/{scheduleId}/homeworks")
    public ResponseEntity<Homework> uploadHomeWork(@RequestBody Homework homework, @PathVariable("scheduleId") Integer scheduleId)
    {
        return new ResponseEntity<>(scheduleService.updateHomework(scheduleId,homework),HttpStatus.CREATED);
    }

    @GetMapping(value = "/{scheduleId}/test_records")
    public ResponseEntity<List<TestRecord>> findTestRecords(@PathVariable("scheduleId") Integer scheduleId)
    {
        return new ResponseEntity<List<TestRecord>>(scheduleService.findAllTestRecords(scheduleId),HttpStatus.OK);
    }

    @GetMapping(value = "/{scheduleId}/sign_records")
    public ResponseEntity<List<SignRecord>> findSignRecords(@PathVariable("scheduleId") Integer scheduleId)
    {
        return new ResponseEntity<List<SignRecord>>(scheduleService.findAllSignRecords(scheduleId),HttpStatus.OK);
    }

    @GetMapping(value = "/{scheduleId}/attendances")
    public ResponseEntity<List<Attendance>> findAttendances(@PathVariable("scheduleId") Integer scheduleId)
    {
        return new ResponseEntity<List<Attendance>>(scheduleService.findAllAttendances(scheduleId),HttpStatus.OK);
    }

    @GetMapping(value = "/{scheduleId}/homeworks")
    public ResponseEntity<List<Homework>> findHomeworks(@PathVariable("scheduleId") Integer scheduleId)
    {
        return new ResponseEntity<List<Homework>>(scheduleService.findAllHomeworks(scheduleId),HttpStatus.OK);
    }

    @GetMapping(value = "/{scheduleId}/arrangement")
    public ResponseEntity<TeacherArrangement> findArrangement(@PathVariable("scheduleId") Integer scheduleId)
    {
        return new ResponseEntity<TeacherArrangement>(scheduleService.findArrangement(scheduleId),HttpStatus.OK);
    }

    @GetMapping(value = "/{scheduleId}/student")
    public ResponseEntity<Student> findStudents(@PathVariable("scheduleId") Integer scheduleId)
    {
        return new ResponseEntity<Student>(scheduleService.findStudent(scheduleId),HttpStatus.OK);
    }
}
