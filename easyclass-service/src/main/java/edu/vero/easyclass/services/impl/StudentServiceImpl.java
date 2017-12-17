package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.ClassSchedule;
import edu.vero.easyclass.domain.Student;
import edu.vero.easyclass.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 23:03 2017/12/17.
 * @since easyclass
 */
@Service
public class StudentServiceImpl implements StudentService
{
    @Override
    public Student findStudentById(Integer userId)
    {
        return null;
    }

    @Override
    public List<ClassSchedule> findSchedule(String id)
    {
        return null;
    }
}
