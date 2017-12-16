package edu.vero.easyclass.controllers;

import edu.vero.easyclass.domain.Notice;
import edu.vero.easyclass.domain.Teacher;
import edu.vero.easyclass.domain.TeacherArrangement;
import edu.vero.easyclass.services.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  23:52 2017/12/14.
 * @since easyclass
 */

@RestController
@RequestMapping(value = "/teachers")
public class TeacherController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherController1.class);

    private TeacherService teacherService;

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @GetMapping(value = "")
    public ResponseEntity<List <Teacher> > findAllTeacher(){
        return  null;

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Teacher> findTeacher(@PathVariable("id")Integer id) {
        return null;
    }

    @GetMapping(value = "/{userId}/arrangements")
    public ResponseEntity<TeacherArrangement> findTeacherArrangement(@PathVariable("userid")Integer userid){
        return null;
        }

    @PostMapping(value = "/{userId}/arrangements")
    public ResponseEntity<List<TeacherArrangement>>createTeacherArrangement(@PathVariable("userid")Integer userid,@RequestBody List list){
        return null;
        }






}
