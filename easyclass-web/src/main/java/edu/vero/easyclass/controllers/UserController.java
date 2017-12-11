package edu.vero.easyclass.controllers;

import edu.vero.easyclass.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 通过spring data jpa 调用方法 api :localhost:8099/users/byname?username=xxx
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUser(@PathVariable("username") String username) {
        return new ResponseEntity<>(userService.getUserByName(username), HttpStatus.OK);
    }
}
