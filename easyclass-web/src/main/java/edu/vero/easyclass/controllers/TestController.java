package edu.vero.easyclass.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.vero.easyclass.domain.OnlineClassTest;
import edu.vero.easyclass.domain.Question;
import edu.vero.easyclass.domain.TeacherArrangement;
import edu.vero.easyclass.services.TestsService;
import io.swagger.annotations.Api;


@Api(description = "在线测试业务")
@RestController
@RequestMapping(value = "/tests")
public class TestController
{

    private TestsService testsService;

    @Autowired
    public void setTestsService(TestsService testsService)
    {
        this.testsService = testsService;
    }

    @GetMapping
    public ResponseEntity<List<OnlineClassTest>> findAllTests()
    {
        return new ResponseEntity<>(testsService.findAllTests(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OnlineClassTest> createTest(@RequestBody OnlineClassTest onlineClassTest)
    {
        return new ResponseEntity<>(testsService.createTest(onlineClassTest), HttpStatus.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<OnlineClassTest> updateTest(@RequestBody OnlineClassTest onlineClassTest)
    {

        return new ResponseEntity<>(testsService.updateTest(onlineClassTest), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{testId}")
    public ResponseEntity<OnlineClassTest> findTest(@PathVariable("testId") Integer testId)
    {
        return new ResponseEntity<>(testsService.findTest(testId), HttpStatus.OK);
    }

    @GetMapping(value = "/{testId}/arrangement")
    public ResponseEntity<TeacherArrangement> findTestArrangement(@PathVariable("testId") Integer testId)
    {
        return new ResponseEntity<>(testsService.findTestArrangement(testId), HttpStatus.OK);
    }

    @GetMapping(value = "/{testId}/questions")
    public ResponseEntity<List<Question>> findTestQuestions(@PathVariable("testId") Integer testId)
    {
        return new ResponseEntity<>(testsService.findTestQuestions(testId), HttpStatus.OK);
    }
    @DeleteMapping(value="/{testId}")
    public ResponseEntity<OnlineClassTest> deleteTest(@PathVariable("testId")Integer testId){
        return new ResponseEntity<>(testsService.deleteTest(testId),HttpStatus.NO_CONTENT);
    }

}