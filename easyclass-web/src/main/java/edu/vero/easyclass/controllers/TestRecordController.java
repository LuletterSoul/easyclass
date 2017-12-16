package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.OnlineClassTest;
import edu.vero.easyclass.domain.TeacherArrangement;
import edu.vero.easyclass.domain.TestRecord;
import edu.vero.easyclass.domain.ClassSchedule;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(description = "测试记录务")
@RestController
@RequestMapping(value = "/test_records")
public class TestRecordController
{

    @GetMapping
    public ResponseEntity<List<TestRecord>> findAllTestRecords()
    {
        return null;
    }

    @PostMapping(value = "/{recordId}")
    public ResponseEntity<TestRecord> createTestRecord(@PathVariable("recordId") Integer recordId,
                                                       @RequestBody TestRecord testRecord)
    {
        return null;
    }

    @GetMapping(value = "/{recordId}/schedule")
    public ResponseEntity<ClassSchedule> findClassSchedule(@PathVariable("recordId") Integer recordId)
    {
        return null;
    }

    @GetMapping(value = "/{recordId}/test")
    public ResponseEntity<OnlineClassTest> findTest(@PathVariable("recordId") Integer recordId)
    {
        return null;
    }

}