package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Attendance;
import edu.vero.easyclass.domain.ClassSchedule;

import edu.vero.easyclass.domain.Courseware;
import edu.vero.easyclass.domain.SignRecord;
import edu.vero.easyclass.services.SignRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(description = "签到记录业务")
@RestController
@RequestMapping(value = "/sign_records")
public class SignRecordController
{

    private SignRecordService signRecordService;

    @Autowired
    public void setSignRecordService(SignRecordService signRecordService)
    {
        this.signRecordService = signRecordService;
    }

    @ApiOperation(value = "找到全部的签到记录（no content）")
    @GetMapping(value = "")
    public ResponseEntity<List<SignRecord>> findAllSignRecords()
    {
        return new ResponseEntity<>(signRecordService.findAllSignRecord(), HttpStatus.OK);
    }

    @ApiOperation(value = "找到该签到记录相关的签到（通过测试）")
    @GetMapping(value = "/{signId}/attendance")
    public ResponseEntity<Attendance> findAttendance(@PathVariable("signId") Integer signId)
    {

        return new ResponseEntity<>(signRecordService.findAttendance(signId), HttpStatus.OK);
    }

    @ApiOperation(value = "找到该签到记录相关的学生选课（no content）")
    @GetMapping(value = "/{signId}/schedule")
    public ResponseEntity<ClassSchedule> findClassSchedule(@PathVariable("signId") Integer signId)
    {

        return new ResponseEntity<>(signRecordService.findClassSchedule(signId), HttpStatus.OK);
    }

    @ApiOperation(value = "创建签到（数据库更新成功 返回no content）")
    @PostMapping(value = "")
    public ResponseEntity<SignRecord> createSignRecord(@RequestBody SignRecord signRecord)
    {
        return new ResponseEntity<>(signRecordService.createSignRecord(signRecord),
            HttpStatus.CREATED);

    }

    @ApiOperation(value = "更新签到(暂时无用未测试）")
    @PutMapping(value = "")
    public ResponseEntity<SignRecord> updateSignRecord(@RequestBody SignRecord signRecord)
    {
        return new ResponseEntity<>(signRecordService.updateSignRecord(signRecord), HttpStatus.OK);
    }

    @ApiOperation(value = "根据Id删除签到(通过测试）")
    @DeleteMapping(value = "/{signRecordId}")
    public ResponseEntity<SignRecord> deleteSignRecord(@PathVariable("signRecordId") Integer signRecordId)
    {
        return new ResponseEntity<>(signRecordService.deleteSignRecord(signRecordId),
            HttpStatus.OK);
    }
}