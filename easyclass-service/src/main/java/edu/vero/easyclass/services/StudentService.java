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
    public Student findStudentById(Integer userId);

    public List<ClassSchedule> findSchedule(Integer userId);

    public Student save(Student student);

    public List<Student> findAll();
}
