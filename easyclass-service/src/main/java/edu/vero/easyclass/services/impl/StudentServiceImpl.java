package edu.vero.easyclass.services.impl;

import edu.vero.easyclass.domain.Student;
import edu.vero.easyclass.repositories.StudentJpaDao;
import edu.vero.easyclass.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}
