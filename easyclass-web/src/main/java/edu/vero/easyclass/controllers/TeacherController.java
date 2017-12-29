package edu.vero.easyclass.controllers;


import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @ApiOperation(value = "查找全部老师(测试通过)")
    @GetMapping(value = "")
    public ResponseEntity<List<Teacher>> findAllTeacher()
    {
        return new ResponseEntity<>(teacherService.findAllTeachers(), HttpStatus.OK);

    }

    @ApiOperation(value = "注册一个老师(测试通过)")
    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher)
    {
        return new ResponseEntity<>(teacherService.createTeacher(teacher), HttpStatus.CREATED);
    }

    @ApiOperation(value = "查找一个老师(测试通过)")
    @GetMapping(value = "/{userId}")
    public ResponseEntity<Teacher> findTeacher(@PathVariable("userId") Integer id)
    {

        return new ResponseEntity<>(teacherService.findTeacher(id), HttpStatus.OK);
    }

    @ApiOperation(value = "查找某位老师的课程(测试通过)")
    @GetMapping(value = "/{userId}/arrangements")
    public ResponseEntity<List<TeacherArrangement>> findTeacherArrangement(@PathVariable("userId") Integer userId)
    {
        return new ResponseEntity<>(teacherService.findTeacherArrangement(userId), HttpStatus.OK);
    }

    @ApiOperation(value = "为老师安排一门课(测试通过)")
    @PostMapping(value = "/{userId}/arrangements")
    public ResponseEntity<List<TeacherArrangement>> createTeacherArrangement(@PathVariable("userId") Integer userId,
                                                                             @RequestBody List<TeacherArrangement> list)
    {
        return new ResponseEntity<>(teacherService.createTeacherArrangement(userId, list),
            HttpStatus.OK);
    }


    @ApiOperation(value = "更新老师信息(测试通过)")
    @PutMapping(value = "")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher)
    {
        return new ResponseEntity<>(teacherService.updateTeacher(teacher), HttpStatus.OK);
    }

    @ApiOperation(value = "删除一位老师(测试通过)")
    @DeleteMapping(value = "/{teacherId}")
    public ResponseEntity<Teacher> deleteTeacher(@PathVariable("teacherId") Integer teacherId)
    {
        return new ResponseEntity<>(teacherService.deleteTeacher(teacherId), HttpStatus.OK);
    }

}
