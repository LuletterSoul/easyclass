package edu.vero.easyclass.controllers;

import edu.vero.easyclass.domain.Question;
import edu.vero.easyclass.domain.QuestionOption;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/questions")
public class Questioncontroller{

    @GetMapping(value = "")
    public ResponseEntity<List<Question> > findAllQuestions(){
        return  null;
    }

    @PostMapping (value = "")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question){
        return  null;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Question> findQuestion(@PathVariable("id")Integer id){
        return  null;
    }

    @GetMapping(value = "/{id}/options")
    public ResponseEntity<List<QuestionOption>> findQuestonOptions(@PathVariable("id")Integer id){
        return  null;
    }



}
