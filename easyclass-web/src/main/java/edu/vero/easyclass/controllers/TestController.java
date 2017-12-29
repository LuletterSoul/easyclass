package edu.vero.easyclass.controllers;


import java.util.List;

import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value="找到所有测试（测试通过）")
    @GetMapping
    public ResponseEntity<List<OnlineClassTest>> findAllTests()
    {
        return new ResponseEntity<>(testsService.findAllTests(), HttpStatus.OK);
    }

    @ApiOperation(value="创建一次测试（测试通过）")
    @PostMapping
    public ResponseEntity<OnlineClassTest> createTest(@RequestBody OnlineClassTest onlineClassTest)
    {
        return new ResponseEntity<>(testsService.createTest(onlineClassTest), HttpStatus.CREATED);
    }

    @ApiOperation(value="更新一次测试（未测试）")
    @PutMapping
    public ResponseEntity<OnlineClassTest> updateTest(@RequestBody OnlineClassTest onlineClassTest)
    {

        return new ResponseEntity<>(testsService.updateTest(onlineClassTest), HttpStatus.CREATED);
    }

    @ApiOperation(value="根据id查找某一次测试（测试通过）")
    @GetMapping(value = "/{testId}")
    public ResponseEntity<OnlineClassTest> findTest(@PathVariable("testId") Integer testId)
    {
        return new ResponseEntity<>(testsService.findTest(testId), HttpStatus.OK);
    }

    @ApiOperation(value="找到测试对应的课程（测试通过）")
    @GetMapping(value = "/{testId}/arrangement")
    public ResponseEntity<TeacherArrangement> findTestArrangement(@PathVariable("testId") Integer testId)
    {
        return new ResponseEntity<>(testsService.findTestArrangement(testId), HttpStatus.OK);
    }

    @ApiOperation(value="找到测试对应的题目（测试通过）")
    @GetMapping(value = "/{testId}/questions")
    public ResponseEntity<List<Question>> findTestQuestions(@PathVariable("testId") Integer testId)
    {
        return new ResponseEntity<>(testsService.findTestQuestions(testId), HttpStatus.OK);
    }

    @ApiOperation(value="根据id删除测试（测试未通过，懒加载问题）")
    @DeleteMapping(value = "/{testId}")
    public ResponseEntity<OnlineClassTest> deleteTest(@PathVariable("testId") Integer testId)
    {
        return new ResponseEntity<>(testsService.deleteTest(testId), HttpStatus.NO_CONTENT);
    }
    
}