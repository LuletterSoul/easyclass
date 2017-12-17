package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.OnlineClassTest;
import edu.vero.easyclass.domain.TeacherArrangement;
import edu.vero.easyclass.domain.TestRecord;
import edu.vero.easyclass.domain.ClassSchedule;
import edu.vero.easyclass.services.TestRecordService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(description = "测试记录务")
@RestController
@RequestMapping(value = "/test_records")
public class TestRecordController
{

    private TestRecordService testRecordService;

    @Autowired
    public void setTestRecordService(TestRecordService testRecordService)
    {
        this.testRecordService = testRecordService;
    }

    @GetMapping
    public ResponseEntity<List<TestRecord>> findAllTestRecords()
    {

        return new ResponseEntity<>(testRecordService.findAllTestRecords(), HttpStatus.OK);
    }

    @PostMapping(value = "/{recordId}")
    public ResponseEntity<TestRecord> createTestRecord(@RequestBody TestRecord testRecord)
    {
        return new ResponseEntity<>(testRecordService.createTestRecord(testRecord),
            HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{recordId}/schedule")
    public ResponseEntity<ClassSchedule> findClassSchedule(@PathVariable("recordId") Integer recordId)
    {

        return new ResponseEntity<>(testRecordService.findClassSchedule(recordId), HttpStatus.OK);
    }

    @GetMapping(value = "/{recordId}/test")
    public ResponseEntity<OnlineClassTest> findTest(@PathVariable("recordId") Integer recordId)
    {

        return new ResponseEntity<>(testRecordService.findTest(recordId), HttpStatus.OK);
    }

}