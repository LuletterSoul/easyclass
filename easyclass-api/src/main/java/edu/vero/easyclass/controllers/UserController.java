package edu.vero.easyclass.controllers;

import edu.vero.easyclass.domain.Student;
import edu.vero.easyclass.domain.User;
import edu.vero.easyclass.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  12:40 2017/12/11.
 * @since easyclass
 */

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return null;
    }
    @PostMapping
    public RequestEntity<Student> registerStudent(@RequestBody Student student){
        return null;
    }
    @GetMapping(value="{userId}")
    public ResponseEntity<User> findUserById(@PathVariable("userId")String userId ){
        return new ResponseEntity<User>(userService.findUserById(userId),HttpStatus.OK);
    }

}
