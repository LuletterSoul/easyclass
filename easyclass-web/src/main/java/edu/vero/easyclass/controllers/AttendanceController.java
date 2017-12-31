package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.*;
import edu.vero.easyclass.services.AttendanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Api(description = "签到业务")
@RestController
@RequestMapping(value = "/attendances")
public class AttendanceController
{

    private AttendanceService attendanceService;

    @Autowired
    public void setAttendanceService(AttendanceService attendanceService)
    {
        this.attendanceService = attendanceService;
    }

    @ApiOperation(value = "创建签到（测试通过）")
    @PostMapping
    public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance)
    {
        return new ResponseEntity<>(attendanceService.createAttendance(attendance),
            HttpStatus.CREATED);
    }

    @ApiOperation(value = "删除一个签到（测试通过）")
    @DeleteMapping(value = "/{attendanceId}")
    public ResponseEntity<Attendance> deleteAttendance(@PathVariable("attendanceId") Integer attendanceId)
    {
        return new ResponseEntity<>(attendanceService.deleteAttendance(attendanceId),
            HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "发起一个属于该签到项下的投票（测试通过）")
    // @ApiImplicitParams({
    // @ApiImplicitParam(name = "attendanceId", value = "签到编号", dataType = "int", paramType =
    // "path", required = true),
    // @ApiImplicitParam(name = "vote", value = "投票的模型数据")})
    @PostMapping(value = "/{attendanceId}/votes")
    public ResponseEntity<Vote> createVote(@PathVariable("attendanceId") Integer attendanceId,
                                           @RequestBody Vote vote)
    {
        return new ResponseEntity<>(attendanceService.createVote(attendanceId, vote),
            HttpStatus.CREATED);
    }

    @ApiOperation(value = "删除签到的二维码(尚未实现)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "attendanceId", value = "签到编号", dataType = "int", paramType = "path", required = true)})
    @DeleteMapping(value = "/{attendanceId}/QR_code")
    public ResponseEntity<QRcode> deleteQRcode(@PathVariable("attendanceId") Integer attendanceId)
    {
        return new ResponseEntity<>(attendanceService.deleteQRcode(attendanceId),
            HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "获取签到的地址，返回一个二维码图片,里面包含学生签到的地址(通过测试)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "attendanceId", value = "签到编号", dataType = "int", paramType = "path", required = true),
        @ApiImplicitParam(name = "scheduleId", value = "课表编号", dataType = "int", paramType = "query", required = true),
        @ApiImplicitParam(name = "width", value = "二维码宽度", dataType = "int", paramType = "query", required = false, defaultValue = "200"),
        @ApiImplicitParam(name = "height", value = "二维码高度", dataType = "int", paramType = "query", required = false, defaultValue = "200"),
        @ApiImplicitParam(name = "format", value = "课表编号", dataType = "int", paramType = "query", required = false, defaultValue = "jpeg")})
    @GetMapping(value = "/{attendanceId}/QR_code")
    public ResponseEntity<byte[]> getQRcode(@PathVariable("attendanceId") Integer attendanceId,
                                            @RequestParam("scheduleId") Integer scheduleId,
                                            @RequestParam(value = "width", defaultValue = "200") Integer width,
                                            @RequestParam(value = "height", defaultValue = "200") Integer height,
                                            @RequestParam(value = "format", defaultValue = "jpeg") String format,
                                            HttpServletRequest request)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(
            attendanceService.findQRcode(attendanceId, scheduleId, height, width, format, request),
            headers, HttpStatus.OK);
    }

    @ApiOperation(value = "更新签到信息(可用于老师主动关闭签到)（测试通过）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "attendanceId", value = "签到编号", dataType = "int", paramType = "path", required = true)})
    @PutMapping(value = "/{attendanceId}")
    public ResponseEntity<Attendance> updateAttendance(@PathVariable("attendanceId") Integer attendanceId)
    {
        return new ResponseEntity<>(attendanceService.updateAttendance(attendanceId),
            HttpStatus.OK);
    }

    @ApiOperation(value = "获取该签到项下的所有签到记录(测试通过)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "attendanceId", value = "签到编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{attendanceId}/sign_records")
    public ResponseEntity<List<SignRecord>> getAttendance(@PathVariable("attendanceId") Integer attendanceId)
    {
        return new ResponseEntity<>(attendanceService.findSignRecords(attendanceId),
            HttpStatus.OK);
    }

    @ApiOperation(value = "增加一条签到记录（测试通过）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "attendanceId", value = "签到编号", dataType = "int", paramType = "path", required = true),
        @ApiImplicitParam(name = "scheduleId", value = "课表编号", dataType = "int", paramType = "query", required = true)})
    @PostMapping(value = "/{attendanceId}/sign_records")
    public ResponseEntity<SignRecord> postSignRecord(@RequestParam("scheduleId") Integer scheduleId,
                                                     @PathVariable("attendanceId") Integer attendanceId)
    {
        return new ResponseEntity<>(attendanceService.createSignRecord(attendanceId, scheduleId),
            HttpStatus.CREATED);
    }

    @ApiOperation(value = "获取该签到项下的所有投票（测试通过）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "attendanceId", value = "签到编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{attendanceId}/votes")
    public ResponseEntity<List<Vote>> getVotes(@PathVariable("attendanceId") Integer attendanceId)
    {
        return new ResponseEntity<>(attendanceService.findVotes(attendanceId), HttpStatus.CREATED);
    }

    @ApiOperation(value = "获取该签到项下的最新投票（测试通过）")
    @GetMapping(value = "/{attendanceId}/newest_vote")
    public ResponseEntity<Vote> findNewestVote(@PathVariable("attendanceId") Integer attendanceId)
    {
        return new ResponseEntity<>(attendanceService.findNewestVote(attendanceId), HttpStatus.OK);
    }

    @ApiOperation(value = "获取已签到的学生列表")
    @GetMapping(value = "/{attendanceId}/attend_students")
    public ResponseEntity<List<Student>> findAttendStudents(@PathVariable("attendanceId") Integer attendanceId) {
        return null;
    }

    @ApiOperation(value = "获取未签到的学生列表")
    @GetMapping(value = "/{attendanceId}/absent_students")
    public ResponseEntity<List<Student>> findUnAttendStudents(@PathVariable("attendanceId") String attendanceId) {
        return null;
    }



}
