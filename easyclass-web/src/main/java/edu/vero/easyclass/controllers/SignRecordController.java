package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Attendance;
import edu.vero.easyclass.domain.ClassSchedule;

import edu.vero.easyclass.domain.SignRecord;
import edu.vero.easyclass.services.SignRecordService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "")
    public ResponseEntity<List<SignRecord>> findAllSignRecords()
    {
        return new ResponseEntity<>(signRecordService.findAllSignRecord(), HttpStatus.OK);
    }

    @GetMapping(value = "/{signId}/attendance")
    public ResponseEntity<Attendance> findAttendance(@PathVariable("signId") Integer signId)
    {

        return new ResponseEntity<>(signRecordService.findAttendance(signId), HttpStatus.OK);
    }

    @GetMapping(value = "/{signId}/schedule")
    public ResponseEntity<ClassSchedule> findClassSchedule(@PathVariable("signId") Integer signId)
    {

        return new ResponseEntity<>(signRecordService.findClassSchedule(signId), HttpStatus.OK);
    }
}