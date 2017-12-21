package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.*;
import edu.vero.easyclass.services.ClassScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "查找所有学生的所有课表")
    @GetMapping
    public ResponseEntity<List<ClassSchedule>> findAllSchedule()
    {
        return null;
    }

    @ApiOperation(value = "学生上传作业(设计上传，尚未实现)")
    @PostMapping(value = "/{scheduleId}/homeworks")
    public ResponseEntity<Homework> uploadHomeWork(@RequestBody Homework homework,
                                                   @PathVariable("scheduleId") Integer scheduleId)
    {
        return new ResponseEntity<>(scheduleService.updateHomework(scheduleId, homework),
            HttpStatus.CREATED);
    }

    @ApiOperation(value = "学生获取给该课表下发起的所有测试记录")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "scheduleId", value = "学生课表的编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{scheduleId}/test_records")
    public ResponseEntity<List<TestRecord>> findTestRecords(@PathVariable("scheduleId") Integer scheduleId)
    {
        return null;
    }

    @ApiOperation(value = "学生获取给该课表下的所有签到记录")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "scheduleId", value = "学生课表的编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{scheduleId}/sign_records")
    public ResponseEntity<List<SignRecord>> findSignRecords(@PathVariable("scheduleId") Integer scheduleId)
    {
        return new ResponseEntity<List<SignRecord>>(scheduleService.findAllSignRecords(scheduleId),
            HttpStatus.OK);
    }

    // @ApiOperation(value = "学生获取给该课表下的所有签到记录")
    // @ApiImplicitParams({
    // @ApiImplicitParam(name = "scheduleId", value = "学生课表的编号", dataType = "int", paramType =
    // "path", required = true)})
    // @GetMapping(value = "/{scheduleId}/attendances")
    // public ResponseEntity<List<Attendance>> findAttendances(@PathVariable("scheduleId") Integer
    // scheduleId)
    // {
    // return null;
    // }

    @ApiOperation(value = "学生下载课件(涉及下载尚未实现)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "scheduleId", value = "学生课表的编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{scheduleId}/homeworks")
    public ResponseEntity<List<Homework>> findHomeworks(@PathVariable("scheduleId") Integer scheduleId)
    {
        return new ResponseEntity<List<Homework>>(scheduleService.findAllHomeworks(scheduleId),
            HttpStatus.OK);
    }

    @ApiOperation(value = "查看该课表对应的教师安排表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "scheduleId", value = "学生课表的编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{scheduleId}/arrangement")
    public ResponseEntity<TeacherArrangement> findArrangement(@PathVariable("scheduleId") Integer scheduleId)
    {
        return new ResponseEntity<TeacherArrangement>(scheduleService.findArrangement(scheduleId),
            HttpStatus.OK);
    }

    @ApiOperation(value = "查看该课表对应的学生信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "scheduleId", value = "学生课表的编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{scheduleId}/student")
    public ResponseEntity<Student> findStudent(@PathVariable("scheduleId") Integer scheduleId)
    {
        return new ResponseEntity<Student>(scheduleService.findStudent(scheduleId), HttpStatus.OK);
    }
}
