package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Homework;
import edu.vero.easyclass.services.HomeworkService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(description = "作业业务")
@RestController
@RequestMapping(value = "/homeworks")
public class HomeworkController
{
    private HomeworkService homeworkService;

    @Autowired
    public void setHomeworkService(HomeworkService homeworkService)
    {
        this.homeworkService = homeworkService;
    }

    @DeleteMapping(value = "/{homeworkId}")
    public ResponseEntity<Homework> deleteHomework(@PathVariable("homeworkId") Integer homeworkId)
    {
        return new ResponseEntity<>(homeworkService.deleteHomework(homeworkId),
                HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Homework>> findAllHomeworks()
    {
        return new ResponseEntity<>(homeworkService.findAllHomeworks(),
                HttpStatus.OK);
    }
    @PutMapping(value = "")
    public ResponseEntity<Homework> updateHomework( @RequestBody Homework homework)
    {
        return new ResponseEntity<>(homeworkService.updateHomework(homework),
                HttpStatus.OK);
    }
    @PostMapping(value = "")
    public ResponseEntity<Homework> createHomework( @RequestBody Homework homework)
    {
        return new ResponseEntity<>(homeworkService.createHomework(homework),
                HttpStatus.CREATED);
    }
}
