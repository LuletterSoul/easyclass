package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Student;
import edu.vero.easyclass.domain.User;
import edu.vero.easyclass.services.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 12:40 2017/12/11.
 * @since easyclass
 */
@Api(description = "用户业务")
@RestController
@RequestMapping(value = "/users")
public class UserController
{

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll()
    {
        return new ResponseEntity<>(userService.findAll(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> registerStudent(@RequestBody Student student)
    {
        return new ResponseEntity<Student>(userService.registerStudent(student),HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable("userId") Integer userId)
    {
        return new ResponseEntity<User>(userService.findUserById(userId),HttpStatus.OK);
    }

}
