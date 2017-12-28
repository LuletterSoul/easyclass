package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Attendance;
import edu.vero.easyclass.domain.QRcode;
import edu.vero.easyclass.domain.SignRecord;
import edu.vero.easyclass.domain.Vote;
import edu.vero.easyclass.services.AttendanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
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

    @PostMapping
    public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance)
    {
        return new ResponseEntity<>(attendanceService.createAttendance(attendance),
            HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{attendanceId}")
    public ResponseEntity<Attendance> deleteAttendance(@PathVariable("attendanceId") Integer attendanceId)
    {
        return new ResponseEntity<>(attendanceService.deleteAttendance(attendanceId),
            HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "发起一个属于该签到项下的投票")
//    @ApiImplicitParams({
//        @ApiImplicitParam(name = "attendanceId", value = "签到编号", dataType = "int", paramType = "path", required = true),
//        @ApiImplicitParam(name = "vote", value = "投票的模型数据")})
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

    @ApiOperation(value = "获取签到的二维码(尚未实现)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "attendanceId", value = "签到编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{attendanceId}/QR_code")
    public ResponseEntity<QRcode> getQRcode(@PathVariable("attendanceId") Integer attendanceId)
    {
        return new ResponseEntity<>(attendanceService.findQRcode(attendanceId), HttpStatus.OK);
    }

    @ApiOperation(value = "更新签到信息(可用于老师主动关闭签到)（测试通过）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "attendanceId", value = "签到编号", dataType = "int", paramType = "path", required = true)})
    @PutMapping(value = "/{attendanceId}")
    public ResponseEntity<Attendance> updateAttendance(@PathVariable("attendanceId") Integer attendanceId)
    {
        return new ResponseEntity<>(attendanceService.updateAttendance(attendanceId), HttpStatus.OK);
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

    @ApiOperation(value = "获取该签到项下的所有投票（）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "attendanceId", value = "签到编号", dataType = "int", paramType = "path", required = true)})
    @GetMapping(value = "/{attendanceId}/votes")
    public ResponseEntity<List<Vote>> getVotes(@PathVariable("attendanceId") Integer attendanceId)
    {
        return new ResponseEntity<>(attendanceService.findVotes(attendanceId), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{attendanceId}/newest_vote")
    public ResponseEntity<Vote> findNewestVote(@PathVariable("attendanceId") Integer attendanceId)
    {
        return new ResponseEntity<>(attendanceService.findNewestVote(attendanceId), HttpStatus.OK);
    }
}
