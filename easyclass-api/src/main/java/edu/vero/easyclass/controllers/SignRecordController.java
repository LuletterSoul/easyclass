package edu.vero.easyclass.controllers;

import edu.vero.easyclass.domain.Attendance;
import edu.vero.easyclass.domain.ClassSchedule;

import edu.vero.easyclass.domain.SignRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sign_records")
public class SignRecordController{

    @GetMapping(value = "")
    public ResponseEntity<List<SignRecord>> findAllSignRecords(){
        return  null;
    }

    @GetMapping(value = "")
    public ResponseEntity<Attendance> findAttendence(@PathVariable("id")Integer id){
        return  null;
    }

    @GetMapping(value = "")
    public ResponseEntity<ClassSchedule> findClassSchedule(@PathVariable("id")Integer id){
        return  null;
    }
}