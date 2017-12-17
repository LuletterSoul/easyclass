package edu.vero.easyclass.services.impl;

import edu.vero.easyclass.domain.ClassSchedule;
import edu.vero.easyclass.domain.Student;
import edu.vero.easyclass.repositories.ClassScheduleJpaDao;
import edu.vero.easyclass.repositories.StudentJpaDao;
import edu.vero.easyclass.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
    private ClassScheduleJpaDao scheduleJpaDao;

    @Autowired
    public void setStudentJpaDao(StudentJpaDao studentJpaDao) {
        this.studentJpaDao = studentJpaDao;
    }

    public Student findStudentById(Integer userId){
        return studentJpaDao.findOne(userId);
    }

    @Override
    public List<ClassSchedule> findSchedule(String id) {
        Long stuId = Long.parseLong(id);
        return null;
    }

    @Override
    public Student save(Student student) {
        return studentJpaDao.save(student);
    }

    @Override
    public List<Student> findAll() {
        return null;
    }
}
