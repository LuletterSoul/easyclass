package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Question;
import edu.vero.easyclass.domain.QuestionOption;
import edu.vero.easyclass.repositories.QuestionJpaDao;
import edu.vero.easyclass.services.QuestionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(description = "在线测试问题业务")
@RestController
@RequestMapping(value = "/questions")
public class QuestionController
{
    private QuestionService questionService;

    @Autowired
    public void setQuestionService(QuestionService questionService)
    {
        this.questionService = questionService;
    }

    @GetMapping
    public ResponseEntity<List<Question>> findAllQuestions()
    {
        return new ResponseEntity<>(questionService.findAllQuestions(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question)
    {
        return new ResponseEntity<>(questionService.createQuestion(question), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{questionId}")
    public ResponseEntity<Question> findQuestion(@PathVariable("questionId") Integer questionId)
    {
        return new ResponseEntity<>(questionService.findQuestion(questionId), HttpStatus.OK);
    }

    @GetMapping(value = "/{questionId}/options")
    public ResponseEntity<List<QuestionOption>> findQuestionOptions(@PathVariable("questionId") Integer questionId)
    {
        return new ResponseEntity<>(questionService.findQuestionOptions(questionId),
            HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question)
    {
        return new ResponseEntity<>(questionService.updateQuestion(question), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{questionId}")
    public ResponseEntity<Question> deleteQuestion(@PathVariable("questionId") Integer questionId)
    {
        return new ResponseEntity<>(questionService.deleteQuestion(questionId), HttpStatus.OK);
    }

}
