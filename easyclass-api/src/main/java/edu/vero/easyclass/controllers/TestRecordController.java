package edu.vero.easyclass.controllers;

import edu.vero.easyclass.domain.OnlineClassTest;
import edu.vero.easyclass.domain.TeacherArrangement;
import edu.vero.easyclass.domain.TestRecord;
import edu.vero.easyclass.domain.ClassSchedule;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/test_records")
public class TestRecordController{

    @GetMapping(value = "")
    public ResponseEntity<List<TestRecord> > findAllTestRecords(){
        return  null;
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<TestRecord>createTestRecord(@PathVariable("id")Integer id, @RequestBody TestRecord testRecord){
        return null;
    }

    @GetMapping(value = "/{id}/schedule")
    public ResponseEntity<ClassSchedule>findClassSchedule(@PathVariable("id")Integer id){
        return null;
    }

    @GetMapping(value = "/{id}/test")
    public ResponseEntity<OnlineClassTest>findTest(@PathVariable("id")Integer id){
        return null;
    }


}