package edu.vero.easyclass.services.impl;

import edu.vero.easyclass.domain.ClassSchedule;
import edu.vero.easyclass.domain.Student;
import edu.vero.easyclass.repositories.ClassScheduleJpaDao;
import edu.vero.easyclass.repositories.StudentJpaDao;
import edu.vero.easyclass.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  21:06 2017/12/14.
 * @since easyclass
 */

@Service
public class StudentServiceImpl implements StudentService {
    private StudentJpaDao studentJpaDao;


    @Autowired
    public void setStudentJpaDao(StudentJpaDao studentJpaDao) {
        this.studentJpaDao = studentJpaDao;
    }

    public Student findStudentById(Integer userId){
        return studentJpaDao.findOne(userId);
    }

    @Override
    public List<ClassSchedule> findSchedule(Integer userId) {
        return new ArrayList<ClassSchedule>(studentJpaDao.findOne(userId).getSchedules());
    }


    @Override
    public Student save(Student student) {
        return studentJpaDao.saveAndFlush(student);
    }

    @Override
    public List<Student> findAll() {
        return studentJpaDao.findAll();
    }
}
