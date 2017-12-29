package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.OnlineClassTest;
import edu.vero.easyclass.domain.TeacherArrangement;
import edu.vero.easyclass.domain.TestRecord;
import edu.vero.easyclass.domain.ClassSchedule;
import edu.vero.easyclass.services.TestRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "找到所有的测试记录(通过测试)")
    @GetMapping
    public ResponseEntity<List<TestRecord>> findAllTestRecords()
    {

        return new ResponseEntity<>(testRecordService.findAllTestRecords(), HttpStatus.OK);
    }

    @ApiOperation(value = "创建建测试记录(通过测试)")
    @PostMapping
    public ResponseEntity<TestRecord> createTestRecord(@RequestBody TestRecord testRecord)
    {
        return new ResponseEntity<>(testRecordService.createTestRecord(testRecord),
            HttpStatus.CREATED);
    }

    @ApiOperation(value = "获取做测试的学生信息(通过测试)")
    @GetMapping(value = "/{recordId}/schedule")
    public ResponseEntity<ClassSchedule> findClassSchedule(@PathVariable("recordId") Integer recordId)
    {

        return new ResponseEntity<>(testRecordService.findClassSchedule(recordId), HttpStatus.OK);
    }

    @ApiOperation(value = "获取测试记录对应的测试信息(通过测试)")
    @GetMapping(value = "/{recordId}/test")
    public ResponseEntity<OnlineClassTest> findTest(@PathVariable("recordId") Integer recordId)
    {

        return new ResponseEntity<>(testRecordService.findTest(recordId), HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<TestRecord> updateTestRecord(@RequestBody TestRecord testRecord)
    {
        return new ResponseEntity<>(testRecordService.updateTestRecord(testRecord), HttpStatus.OK);
    }

    @ApiOperation(value = "删除一条测试记录(通过测试)")
    @DeleteMapping(value = "/{testId}")
    public ResponseEntity<TestRecord> deleteTestRecord(@PathVariable("testId") Integer testId)
    {
        return new ResponseEntity<>(testRecordService.deleteTestRecord(testId), HttpStatus.OK);
    }

}