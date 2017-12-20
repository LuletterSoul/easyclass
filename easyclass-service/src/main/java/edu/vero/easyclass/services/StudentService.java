package edu.vero.easyclass.services;


import edu.vero.easyclass.domain.ClassSchedule;
import edu.vero.easyclass.domain.Student;
import org.springframework.http.HttpStatus;

import java.util.List;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 20:52 2017/12/14.
 * @since easyclass
 */

public interface StudentService
{
    Student findStudentById(Integer userId);

    List<ClassSchedule> findSchedule(Integer userId);

    Student save(Student student);

    List<Student> findAll();

}
