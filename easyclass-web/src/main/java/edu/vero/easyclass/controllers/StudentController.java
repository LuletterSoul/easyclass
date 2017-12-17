package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.ClassSchedule;
import edu.vero.easyclass.domain.Student;
import edu.vero.easyclass.services.StudentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 21:15 2017/12/14.
 * @since easyclass
 */
@Api(description = "学生业务")
@RestController
@RequestMapping(value = "/students")
public class StudentController
{
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<Student> findStudent(@PathVariable("userId") Integer userId)
    {
        return new ResponseEntity<>(studentService.findStudentById(userId), HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}/schedules")
    public ResponseEntity<List<ClassSchedule>> findSchedule(@PathVariable("userId") Integer userId)
    {
        return null;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Student>> findAllStudents()
    {
        return null;
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<Student> findStudentById(@PathVariable("userId") Integer userId)
    {
        return null;
    }

}
