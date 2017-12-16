package edu.vero.easyclass.controllers;


import java.util.List;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.vero.easyclass.domain.Teacher;
import edu.vero.easyclass.domain.TeacherArrangement;
import edu.vero.easyclass.services.TeacherService;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 23:52 2017/12/14.
 * @since easyclass
 */
@Api(description = "教师业务")
@RestController
@RequestMapping(value = "/teachers")
public class TeacherController
{

    private TeacherService teacherService;

    @Autowired
    public void setTeacherService(TeacherService teacherService)
    {
        this.teacherService = teacherService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Teacher>> findAllTeacher()
    {
        return null;

    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<Teacher> findTeacher(@PathVariable("userId") Integer id)
    {
        return null;
    }

    @GetMapping(value = "/{userId}/arrangements")
    public ResponseEntity<TeacherArrangement> findTeacherArrangement(@PathVariable("userId") Integer userId)
    {
        return null;
    }

    @PostMapping(value = "/{userId}/arrangements")
    public ResponseEntity<List<TeacherArrangement>> createTeacherArrangement(@PathVariable("userId") Integer userId,
                                                                             @RequestBody List<TeacherArrangement> list)
    {
        return null;
    }

}
