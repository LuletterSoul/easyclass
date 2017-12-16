package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Attendance;
import edu.vero.easyclass.domain.QRcode;
import edu.vero.easyclass.domain.Vote;
import edu.vero.easyclass.services.AttendanceService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping(value = "/{attendanceId}/votes")
    public ResponseEntity<Vote> createVote(@PathVariable("attendanceId") Integer attendanceId)
    {
        return null;
    }

    @DeleteMapping(value = "/{attendanceId}/QR_code")
    public ResponseEntity<QRcode> deleteQRcode(@PathVariable("attendanceId") Integer attendanceId)
    {
        return null;
    }

    @GetMapping(value = "/{attendanceId}/QR_code")
    public ResponseEntity<QRcode> getQRcode(@PathVariable("attendanceId") Integer attendanceId)
    {
        return null;
    }

    @PutMapping
    public ResponseEntity<Attendance> updateAttendance(@RequestBody Attendance attendance)
    {
        return null;
    }

    @GetMapping(value = "/sign_records")
    public ResponseEntity<Attendance> getAttendance(@RequestBody Attendance attendance)
    {
        return null;
    }

}
