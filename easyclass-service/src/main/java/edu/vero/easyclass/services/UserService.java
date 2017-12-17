package edu.vero.easyclass.services;

import edu.vero.easyclass.domain.Student;
import edu.vero.easyclass.domain.User;
import org.springframework.http.ResponseEntity;

import javax.xml.ws.Response;
import java.util.List;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  12:35 2017/12/11.
 * @since easyclass
 */

public interface UserService {
    public User findUserById(Integer userId);
    public Student registerStudent(Student student);
    public List<User> findAll();
}