package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.OnlineClassTest;
import edu.vero.easyclass.domain.Question;
import edu.vero.easyclass.domain.TeacherArrangement;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(description = "在线业务")
@RestController
@RequestMapping(value = "/tests")
public class TestController
{

    @GetMapping
    public ResponseEntity<List<OnlineClassTest>> findAllTests()
    {
        return null;
    }

    @PostMapping
    public ResponseEntity<OnlineClassTest> createTest(@RequestBody OnlineClassTest onlineClassTest)
    {
        return null;
    }

    @PutMapping
    public ResponseEntity<OnlineClassTest> updateTest(@RequestBody OnlineClassTest onlineClassTest)
    {
        return null;
    }

    @GetMapping(value = "/{testId}")
    public ResponseEntity<OnlineClassTest> findTest(@PathVariable("testId") Integer testId)
    {
        return null;
    }

    @GetMapping(value = "/{testId}/arrangement")
    public ResponseEntity<TeacherArrangement> findTestArrangement(@PathVariable("testId") Integer testId)
    {
        return null;
    }

    @GetMapping(value = "/{testId}/questions")
    public ResponseEntity<List<Question>> findTestQuestions(@PathVariable("testId") Integer testId)
    {
        return null;
    }
}