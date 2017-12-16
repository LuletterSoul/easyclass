package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Notice;
import edu.vero.easyclass.domain.Teacher;
import edu.vero.easyclass.services.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 23:52 2017/12/14.
 * @since easyclass
 */

@RestController
@RequestMapping(value = "/teachers")
public class TeacherController
{

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherController.class);

    private TeacherService teacherService;

    @Autowired
    public void setTeacherService(TeacherService teacherService)
    {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<Teacher> post(@RequestBody Teacher teacher)
    {
        return new ResponseEntity<>(teacherService.saveTeacher(teacher), HttpStatus.CREATED);
    }

    @PostMapping(value = "/{userId}/arrangements/{arrangementId}/notices")
    public ResponseEntity<Notice> createNotice(@PathVariable("userId") String userId,
                                               @RequestBody Notice notice,
                                               @PathVariable("arrangementId") String arrangementId)
    {
        return null;
    }
}
