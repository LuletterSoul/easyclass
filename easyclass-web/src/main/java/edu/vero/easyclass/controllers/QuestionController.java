package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Question;
import edu.vero.easyclass.domain.QuestionOption;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(description = "在线测试问题业务")
@RestController
@RequestMapping(value = "/questions")
public class QuestionController
{

    @GetMapping
    public ResponseEntity<List<Question>> findAllQuestions()
    {
        return null;
    }

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question)
    {
        return null;
    }

    @GetMapping(value = "/{questionId}")
    public ResponseEntity<Question> findQuestion(@PathVariable("questionId") Integer questionId)
    {
        return null;
    }

    @GetMapping(value = "/{questionId}/options")
    public ResponseEntity<List<QuestionOption>> findQuestionOptions(@PathVariable("questionId") Integer questionId)
    {
        return null;
    }

}
