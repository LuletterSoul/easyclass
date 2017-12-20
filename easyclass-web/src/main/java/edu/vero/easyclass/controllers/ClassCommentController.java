package edu.vero.easyclass.controllers;

import edu.vero.easyclass.domain.ClassTimeComment;
import edu.vero.easyclass.services.ClassCommentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(description = "课后评教")
@RestController
@RequestMapping(value = "/class_comment")
public class ClassCommentController {
    private ClassCommentService classCommentService;

    @Autowired
    public void setClassCommentService(ClassCommentService classCommentService) {
        this.classCommentService = classCommentService;
    }

    @PostMapping
    public ResponseEntity<ClassTimeComment> postClassComment(@RequestParam("timeId") Integer timeId, @RequestParam("scheduleId") Integer scheduleId, @RequestBody ClassTimeComment comment)
    {
        return new ResponseEntity<>(classCommentService.save(timeId,scheduleId,comment), HttpStatus.CREATED);
    }
}
