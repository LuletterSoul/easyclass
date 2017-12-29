package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.ClassSchedule;
import edu.vero.easyclass.domain.Student;
import edu.vero.easyclass.services.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "根据id查找学生对应的选课（测试通过）")
    @GetMapping(value = "/{userId}/schedules")
    public ResponseEntity<List<ClassSchedule>> findSchedule(@PathVariable("userId") Integer userId)
    {
        return new ResponseEntity<List<ClassSchedule>>(studentService.findSchedule(userId),
            HttpStatus.OK);
    }

    @ApiOperation(value = "获得全部学生列表（测试通过）")
    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents()
    {
        return new ResponseEntity<List<Student>>(studentService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "根据id查找学生（测试通过）")
    @GetMapping(value = "/{userId}")
    public ResponseEntity<Student> findStudentById(@PathVariable("userId") Integer userId)
    {
        return new ResponseEntity<Student>(studentService.findStudentById(userId), HttpStatus.OK);
    }

    @ApiOperation(value = "添加一个学生（测试通过）")
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student)
    {
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

    @ApiOperation(value = "根据id删除一个学生（测试通过）")
    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("userId") Integer userId)
    {
        return new ResponseEntity<>(studentService.deleteStudent(userId), HttpStatus.NO_CONTENT);
    }

}
