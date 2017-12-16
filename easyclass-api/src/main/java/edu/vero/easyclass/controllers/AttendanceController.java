package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Attendance;
import edu.vero.easyclass.domain.QRcode;
import edu.vero.easyclass.domain.Vote;
import edu.vero.easyclass.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/attendances")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping(value="/{id}/votes")
    public ResponseEntity<Vote> createVote(@PathVariable("id") String id){
        return null;
    }
    @DeleteMapping(value="/{id}/QR_code")
    public ResponseEntity<QRcode> deleteQRcode(@PathVariable String id){
        return null;
    }
    @GetMapping(value="/{id}/QR_code")
    public ResponseEntity<QRcode> getQRcode(@PathVariable String id){
        return null;
    }
    @PutMapping
    public ResponseEntity<Attendance> updateAttendance(@RequestBody Attendance attendance){
        return null;
    }
    @GetMapping(value="/sign_records")
    public ResponseEntity<Attendance> getAttendance(@RequestBody Attendance attendance){
        return null;
    }

}
