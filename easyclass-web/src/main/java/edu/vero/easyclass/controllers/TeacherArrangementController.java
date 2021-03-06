package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.*;
import edu.vero.easyclass.services.TeacherArrangementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 0:09 2017/12/15.
 * @since easyclass
 */
@Api(description = "教师安排表业务")
@RestController
@RequestMapping(value = "/arrangements")
public class TeacherArrangementController
{

    private TeacherArrangementService teacherArrangementService;

    @Autowired
    public void setTeacherArrangementService(TeacherArrangementService teacherArrangementService)
    {
        this.teacherArrangementService = teacherArrangementService;
    }

    @ApiOperation(value = "教师创建一个公告,此公告跟对应的教师安排相关联（测试通过）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "arrangementId", value = "教师安排表的编号", dataType = "int", paramType = "path", required = true)})
    @PostMapping(value = "/{arrangementId}/notices")
    public ResponseEntity<Notice> createNotice(@PathVariable("arrangementId") Integer arrangementId,
                                               @RequestBody Notice notice)
    {
        return new ResponseEntity<>(teacherArrangementService.createNotice(arrangementId, notice),
            HttpStatus.CREATED);
    }

    @ApiOperation(value = "教师创建一个在线测试,此测试跟对应的教师安排相关联（测试通过）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "arrangementId", value = "教师安排表的编号", dataType = "int", paramType = "path", required = true)})
    @PostMapping(value = "/{arrangementId}/tests")
    public ResponseEntity<OnlineClassTest> createOnlineClassTest(@PathVariable("arrangementId") Integer arrangementId,
                                                                 @RequestBody OnlineClassTest onlineClassTest)
    {
        return new ResponseEntity<>(
            teacherArrangementService.createOnlineClassTest(arrangementId, onlineClassTest),
            HttpStatus.CREATED);
    }

    @ApiOperation(value = "获取所有老师的所有安排表（测试通过）")
    @GetMapping
    public ResponseEntity<List<TeacherArrangement>> findAllArrangements()
    {
        return new ResponseEntity<>(teacherArrangementService.findAllArrangements(),
            HttpStatus.OK);
    }

    @ApiOperation(value = "获取给门课的所有课件(此API涉及下载,尚未实现)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "arrangementId", value = "教师安排表的编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{arrangementId}/coursewares")
    public ResponseEntity<List<Courseware>> findAllCoursewares(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<>(teacherArrangementService.findAllCoursewares(arrangementId),
            HttpStatus.OK);
    }

    @ApiOperation(value = "获取该门课的最新公告（测试通过）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "arrangementId", value = "教师安排表的编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{arrangementId}/notices/newest")
    public ResponseEntity<Notice> findNewestNotices(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<>(teacherArrangementService.findNewestNotices(arrangementId),
            HttpStatus.OK);
    }

    @ApiOperation(value = "创建该门课下的签到（测试通过）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "arrangementId", value = "教师安排表的编号", dataType = "int", paramType = "path", required = true)})
    @PostMapping(value = "/{arrangementId}/attendances")
    public ResponseEntity<Attendance> createAttendance(@PathVariable("arrangementId") Integer arrangementId,
                                                       @RequestBody Attendance attendance)
    {
        return new ResponseEntity<>(
            teacherArrangementService.createAttendance(arrangementId, attendance),
            HttpStatus.CREATED);
    }

    @ApiOperation(value = "创建该门课下的签到（测试通过）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "arrangementId", value = "教师安排表的编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{arrangementId}/attendances")
    public ResponseEntity<List<Attendance>> getAttendances(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<>(teacherArrangementService.getAttendance(arrangementId),
            HttpStatus.OK);
    }

    @ApiOperation(value = "获取特定的教师安排表（测试通过）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "arrangementId", value = "教师安排表的编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{arrangementId}")
    public ResponseEntity<TeacherArrangement> findArrangement(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<>(teacherArrangementService.findArrangement(arrangementId),
            HttpStatus.OK);
    }

    @ApiOperation(value = "获取给该门课下发起的所有测试（未设置参数 测试通过）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "arrangementId", value = "教师安排表的编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{arrangementId}/tests")
    public ResponseEntity<List<OnlineClassTest>> findAllOnlineClassTest(@PathVariable("arrangementId") Integer arrangementId,
                                                                        @RequestParam(value = "isOpening", defaultValue = "true") Boolean isOpening,
                                                                        @RequestParam(value = "isTimeOut", defaultValue = "false") Boolean isTimeOut,
                                                                        @RequestParam(value = "isFinished", defaultValue = "false") Boolean isFinished)
    {
        return new ResponseEntity<>(
            teacherArrangementService.findAllOnlineClassTest(arrangementId), HttpStatus.OK);
    }

    @ApiOperation(value = "获取该门课下的所有上课时间（测试通过）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "arrangementId", value = "教师安排表的编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{arrangementId}/times")
    public ResponseEntity<List<ClassTime>> findAllClassTime(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<>(teacherArrangementService.findAllClassTime(arrangementId),
            HttpStatus.OK);
    }

    @ApiOperation(value = "获取该门课下的所有学生总评信息（测试通过）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "arrangementId", value = "教师安排表的编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{arrangementId}/comments")
    public ResponseEntity<List<CourseComment>> findAllCourseComment(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<List<CourseComment>>(
            teacherArrangementService.findAllCourseComment(arrangementId), HttpStatus.OK);
    }

    @ApiOperation(value = "获取该教师安排表对应的课程详情（测试通过）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "arrangementId", value = "教师安排表的编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{arrangementId}/course")
    public ResponseEntity<Course> findCourse(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<>(teacherArrangementService.findCourse(arrangementId),
            HttpStatus.OK);
    }

    @ApiOperation(value = "获取该门课下的所有公告(测试通过)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "arrangementId", value = "教师安排表的编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{arrangementId}/notices")
    public ResponseEntity<List<Notice>> findAllNotice(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<>(teacherArrangementService.findAllNotice(arrangementId),
            HttpStatus.OK);
    }

    @ApiOperation(value = "获取该门课对应的老师详情（测试通过）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "arrangementId", value = "教师安排表的编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{arrangementId}/teacher")
    public ResponseEntity<Teacher> findTeacher(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<>(teacherArrangementService.findTeacher(arrangementId),
            HttpStatus.OK);
    }

    @ApiOperation(value = "更新一门课程的安排(未测试)")
    @PutMapping(value = "")
    public ResponseEntity<TeacherArrangement> updateArrangement(@RequestBody TeacherArrangement teacherArrangement)
    {
        return new ResponseEntity<>(
            teacherArrangementService.updateArrangement(teacherArrangement), HttpStatus.OK);
    }

    @ApiOperation(value = "安排一门课程（测试通过）")
    @PostMapping(value = "")
    public ResponseEntity<TeacherArrangement> createArrangement(@RequestBody TeacherArrangement teacherArrangement)
    {
        return new ResponseEntity<>(
            teacherArrangementService.createArrangement(teacherArrangement), HttpStatus.CREATED);
    }

    @ApiOperation(value = "删除一门课程的安排（测试通过）")
    @DeleteMapping(value = "/{arrangementId}")
    public ResponseEntity<TeacherArrangement> deleteArrangement(@PathVariable("arrangementId") Integer arrangeId)
    {
        return new ResponseEntity<>(teacherArrangementService.deleteArrangement(arrangeId),
            HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "获取该门课下正在开放的测试（测试通过）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "arrangementId", value = "教师安排表的编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{arrangementId}/opening_tests")
    public ResponseEntity<List<OnlineClassTest>> findOpeningTests(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<>(teacherArrangementService.findOpeningTests(arrangementId),
            HttpStatus.OK);
    }

    @ApiOperation(value = "获取该门课下已经关闭的测试（测试通过）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "arrangementId", value = "教师安排表的编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{arrangementId}/time_out_tests")
    public ResponseEntity<List<OnlineClassTest>> findTimeOutTests(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<>(teacherArrangementService.findTimeOutTests(arrangementId),
            HttpStatus.OK);
    }

    @ApiOperation(value = "获取该门课下最新发布的测试（测试通过）")
    @GetMapping(value = "/{arrangementId}/newest_test")
    public ResponseEntity<OnlineClassTest> findNewestTest(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<>(teacherArrangementService.findNewestTest(arrangementId),
            HttpStatus.OK);
    }

    @ApiOperation(value = "给该门课程下的所有学生发布作业(测试通过)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "arrangementId", value = "教师安排表的编号", dataType = "int", paramType = "path", required = true)})
    @PostMapping(value = "/{arrangementId}/homeworks")
    public ResponseEntity<Homework> arrangeHomework(@PathVariable("arrangementId") Integer arrangementId,
                                                    @RequestBody Homework homework)
    {
        return new ResponseEntity<>(
            teacherArrangementService.arrangeHomework(arrangementId, homework),
            HttpStatus.CREATED);
    }

    @ApiOperation(value = "获取该门课发布的所有作业,顺序按时间从早到晚(测试通过)")
    @GetMapping(value = "/{arrangementId}/homeworks")
    public ResponseEntity<List<Homework>> findAllHomeworks(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<>(teacherArrangementService.findAllHomework(arrangementId),
            HttpStatus.OK);
    }

    @ApiOperation(value = "返回所有未上交作业的学生列表(通过测试)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "arrangementId", value = "教师安排表的编号", dataType = "int", paramType = "path", required = true),
        @ApiImplicitParam(name = "homeworkId", value = "作业编号", dataType = "int", paramType = "query", required = true)})
    @GetMapping(value = "/{arrangementId}/homeworks/unsubmitted_students")
    public ResponseEntity<List<Student>> findAllUnSubmittedStudents(@PathVariable("arrangementId") Integer arrangementId,
                                                                    @RequestParam("homeworkId") Integer homeworkId)
    {
        return new ResponseEntity<>(
            teacherArrangementService.findAllUnSubmittedStudents(arrangementId, homeworkId),
            HttpStatus.OK);
    }

    @ApiOperation(value = "返回所有已上交作业的学生列表(通过测试)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "arrangementId", value = "教师安排表的编号", dataType = "int", paramType = "path", required = true),
        @ApiImplicitParam(name = "homeworkId", value = "作业编号", dataType = "int", paramType = "query", required = true)})
    @GetMapping(value = "/{arrangementId}/homeworks/submitted_students")
    public ResponseEntity<List<Student>> findAllSubmittedStudents(@PathVariable("arrangementId") Integer arrangementId,
                                                                  @RequestParam("homeworkId") Integer homeworkId)
    {
        return new ResponseEntity<>(
            teacherArrangementService.findAllSubmittedStudents(arrangementId, homeworkId),
            HttpStatus.OK);
    }
}
