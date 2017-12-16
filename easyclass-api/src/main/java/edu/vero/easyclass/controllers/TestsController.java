package edu.vero.easyclass.controllers;

import edu.vero.easyclass.domain.OnlineClassTest;
import edu.vero.easyclass.domain.Question;
import edu.vero.easyclass.domain.TeacherArrangement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tests")
public class TestsController{

    @GetMapping(value = "")
    public ResponseEntity<List<OnlineClassTest> > findAllTests(){
        return  null;
    }

    @PostMapping(value = "")
    public ResponseEntity<OnlineClassTest > createTest(@RequestBody OnlineClassTest onlineClassTest){
        return  null;
    }

    @PutMapping(value = "")
    public ResponseEntity<OnlineClassTest> updateTest(@RequestBody OnlineClassTest onlineClassTest){
        return  null;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OnlineClassTest>findTest(@PathVariable("id")Integer id){
        return null;
    }

    @GetMapping(value = "/{id}/arrangement")
    public ResponseEntity<TeacherArrangement>findTestArrangement(@PathVariable("id")Integer id){
        return null;
    }

    @GetMapping(value = "/{id}/arrangement")
    public ResponseEntity<List<Question>>findQuestions(@PathVariable("id")Integer id){
        return null;
    }
}