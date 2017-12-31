package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.*;
import edu.vero.easyclass.services.ClassScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Api(description = "学生课表业务")
@RestController
@RequestMapping(value = "/schedules")
public class ClassScheduleController
{

    private ClassScheduleService scheduleService;

    @Autowired
    public void setScheduleService(ClassScheduleService scheduleService)
    {
        this.scheduleService = scheduleService;
    }

    @ApiOperation(value = "获取所有的选课信息(通过测试)")
    @GetMapping
    public ResponseEntity<List<ClassSchedule>> findAllSchedule()
    {
        return new ResponseEntity<>(scheduleService.findAll(), HttpStatus.OK);
    }

//    // 一次上传一个作业
//    @PostMapping(value = "/{scheduleId}/homeworks/{homeworkId}")
//    public ResponseEntity<Homework> uploadHomeWork(@RequestParam("file") MultipartFile multipartFile,
//                                                   @PathVariable("scheduleId") Integer scheduleId,
//                                                   @PathVariable("homeworkId") Integer homeworkId)
//    {
//        return new ResponseEntity<>(
//            scheduleService.uploadHomework(scheduleId, homeworkId, multipartFile),
//            HttpStatus.CREATED);
//    }

    @ApiOperation(value = "获得学生一门选课下的所有测试（待测试）")
    @GetMapping(value = "/{scheduleId}/all_test")
    public ResponseEntity<List<OnlineClassTest>> findAllTests(@PathVariable("scheduleId") Integer scheduleId){
        return new ResponseEntity<List<OnlineClassTest>>(scheduleService.findAllTests(scheduleId),HttpStatus.OK);
    }

    @ApiOperation(value = "获取所有已经被学生完成的课堂测试(通过测试)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "scheduleId", value = "课表编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{scheduleId}/done_tests")
    public ResponseEntity<List<OnlineClassTest>> findTestsIsDone(@PathVariable("scheduleId") Integer scheduleId)
    {
        return new ResponseEntity<>(scheduleService.findTestsIsDone(scheduleId), HttpStatus.OK);
    }

    @ApiOperation(value = "获取学生所有还未完成的课堂测试（待测试）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "scheduleId", value = "课表编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{scheduleId}/doing_tests")
    public ResponseEntity<List<OnlineClassTest>> findTestsIsExpectedDone(@PathVariable("scheduleId") Integer scheduleId)
    {
        return new ResponseEntity<>(scheduleService.findTestIsExpectedDone(scheduleId),
            HttpStatus.OK);
    }

    @ApiOperation(value = "获取学生的一门选课下的所用课堂测试记录（通过测试）")
    @GetMapping(value = "/{scheduleId}/test_records")
    public ResponseEntity<List<TestRecord>> findTestRecords(@PathVariable("scheduleId") Integer scheduleId)
    {
        return new ResponseEntity<>(scheduleService.findAllTestRecords(scheduleId), HttpStatus.OK);
    }

//    @ApiOperation(value = "testRecordController已有通过测试的方法此方法无用")
//    @PostMapping(value = "/{scheduleId}/test_records")
//    public ResponseEntity<TestRecord> createTestRecord(@PathVariable("scheduleId") Integer scheduleId,
//                                                       @RequestBody TestRecord testRecord)
//    {
//        return null;
//    }

    @ApiOperation(value="找到该门课下的签到记录（通过测试）")
    @GetMapping(value = "/{scheduleId}/sign_records")
    public ResponseEntity<List<SignRecord>> findSignRecords(@PathVariable("scheduleId") Integer scheduleId)
    {
        return new ResponseEntity<>(scheduleService.findAllSignRecords(scheduleId), HttpStatus.OK);
    }

    @ApiOperation(value = "获取学生在该门课下被布置的作业(通过测试)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "scheduleId", value = "课表编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{scheduleId}/homeworks")
    public ResponseEntity<List<Homework>> findHomeworks(@PathVariable("scheduleId") Integer scheduleId)
    {
        return new ResponseEntity<>(scheduleService.findAllHomeworks(scheduleId), HttpStatus.OK);
    }

    @ApiOperation(value = "获取学生在该门课下对应的教师安排(通过测试)")
    @GetMapping(value = "/{scheduleId}/arrangement")
    public ResponseEntity<TeacherArrangement> findArrangement(@PathVariable("scheduleId") Integer scheduleId)
    {
        return new ResponseEntity<>(scheduleService.findArrangement(scheduleId), HttpStatus.OK);
    }

    @ApiOperation(value = "该门选课的学生信息（通过测试）")
    @GetMapping(value = "/{scheduleId}/student")
    public ResponseEntity<Student> findStudents(@PathVariable("scheduleId") Integer scheduleId)
    {
        return new ResponseEntity<>(scheduleService.findStudent(scheduleId), HttpStatus.OK);
    }

    @ApiOperation(value = "删除一门学生选课（通过测试）")
    @DeleteMapping(value = "/{scheduleId}")
    public ResponseEntity<ClassSchedule> deleteSchedule(@PathVariable("scheduleId") Integer scheduleId)
    {
        return new ResponseEntity<>(scheduleService.deleteSchedule(scheduleId),
            HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "创建一门学生选课（通过测试）")
    @PostMapping
    public ResponseEntity<ClassSchedule> createSchedule(@RequestParam("userId") Integer userId,
                                                        @RequestParam("arrangeId") Integer arrangeId)
    {
        return new ResponseEntity<>(scheduleService.createSchedule(userId, arrangeId),
            HttpStatus.CREATED);
    }

}
