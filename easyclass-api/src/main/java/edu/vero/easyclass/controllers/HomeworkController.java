package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Homework;
import edu.vero.easyclass.services.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
        return null;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Homework>> findAllHomeworks()
    {
        return null;
    }
}
