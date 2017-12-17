package edu.vero.easyclass.controllers;

import edu.vero.easyclass.domain.*;
import edu.vero.easyclass.services.ClassScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/schedules")
public class ClassScheduleController {

    private ClassScheduleService scheduleService;

    @Autowired
    public void setScheduleService(ClassScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public ResponseEntity<List<ClassSchedule>> findAllSchedule(){
        return null;
    }

    //一次上传一个作业
    @PostMapping(value="/{scheduleId}/homeworks")
    public ResponseEntity<Homework> uploadHomeWork(@RequestBody Homework homework,
                                                   @PathVariable("scheduleId") String scheduleId){
        return null;
    }
    @GetMapping(value="/{scheduleId}/test_Records")
    public ResponseEntity<List<TestRecord>> findTestRecords(@PathVariable("scheduleId") String id ){
        return null;
    }
    @GetMapping(value="/{scheduleId}/sign_Records")
    public ResponseEntity<List<SignRecord>> findSignRecords(@PathVariable("scheduleId") String id ){
        return null;
    }
    @GetMapping(value="/{scheduleId}/attendances")
    public ResponseEntity<List<Attendance>> findAttendances(@PathVariable("scheduleId") String id ){
        return null;
    }
    @GetMapping(value="/{scheduleId}/homeworks")
    public ResponseEntity<List<Homework>> findHomworks(@PathVariable("scheduleId") String id ){
        return null;
    }
    @GetMapping(value="/{scheduleId}/arragement")
    public ResponseEntity<TeacherArrangement> findArrangement(@PathVariable("scheduleId") String id ){
        return null;
    }
    @GetMapping(value="/{schduleId}/student")
    public ResponseEntity<Student> findStudents(@PathVariable("scheduleId") String id ){
        return null;
    }
}
