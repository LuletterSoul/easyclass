package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Attendance;
import edu.vero.easyclass.domain.ClassSchedule;

import edu.vero.easyclass.domain.SignRecord;
import io.swagger.annotations.Api;
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

    @GetMapping(value = "")
    public ResponseEntity<List<SignRecord>> findAllSignRecords()
    {
        return null;
    }

    @GetMapping(value = "/{signId}/attendance")
    public ResponseEntity<Attendance> findAttendance(@PathVariable("signId") Integer signId)
    {
        return null;
    }

    @GetMapping(value = "/{signId}/schedule")
    public ResponseEntity<ClassSchedule> findClassSchedule(@PathVariable("signId") Integer signId)
    {
        return null;
    }
}