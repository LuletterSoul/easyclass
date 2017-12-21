package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Attendance;
import edu.vero.easyclass.domain.QRcode;
import edu.vero.easyclass.domain.SignRecord;
import edu.vero.easyclass.domain.Vote;
import edu.vero.easyclass.services.AttendanceService;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value="/create/{arrangeId}")

    public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance,@PathVariable("arrangeId") Integer arrangeId){
        return new ResponseEntity<>(attendanceService.createAttendance(attendance,arrangeId),HttpStatus.CREATED);
    }

    @DeleteMapping(value="/{attendanceId}/delete")
    public ResponseEntity<Attendance> deleteAttendance(@PathVariable("attendanceId")Integer attendanceId){
        return new ResponseEntity<>(attendanceService.deleteAttendance(attendanceId),HttpStatus.NO_CONTENT);
    }


    @PostMapping(value = "/{attendanceId}/votes")
    public ResponseEntity<Vote> createVote(@PathVariable("attendanceId") Integer attendanceId,
                                           @RequestBody Vote vote)
    {
        return new ResponseEntity<>(attendanceService.createVote(attendanceId, vote),
            HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{attendanceId}/QR_code")
    public ResponseEntity<QRcode> deleteQRcode(@PathVariable("attendanceId") Integer attendanceId)
    {
        return new ResponseEntity<>(attendanceService.deleteQRcode(attendanceId),
            HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/{attendanceId}/QR_code")
    public ResponseEntity<QRcode> getQRcode(@PathVariable("attendanceId") Integer attendanceId)
    {
        return new ResponseEntity<>(attendanceService.findQRcode(attendanceId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Attendance> updateAttendance(@RequestBody Attendance attendance)
    {
        return new ResponseEntity<>(attendanceService.updateAttendance(attendance), HttpStatus.OK);
    }

    @GetMapping(value = "/{attendanceId}/sign_records")
    public ResponseEntity<List<SignRecord>> getAttendance(@PathVariable("attendanceId") Integer attendanceId)
    {
        return new ResponseEntity<List<SignRecord>>(
            attendanceService.findSignRecords(attendanceId), HttpStatus.OK);
    }

}
