package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.Student;
import edu.vero.easyclass.domain.User;
import edu.vero.easyclass.repositories.StudentJpaDao;
import edu.vero.easyclass.repositories.UserJpaDao;
import edu.vero.easyclass.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 12:36 2017/12/11.
 * @since easyclass
 */

@Service
public class UserServiceImpl implements UserService
{

    private UserJpaDao userJpaDao;

    private StudentJpaDao studentJpaDao;

    @Autowired
    public void setStudentJpaDao(StudentJpaDao studentJpaDao)
    {
        this.studentJpaDao = studentJpaDao;
    }

    @Autowired
    public void setUserJpaDao(UserJpaDao userJpaDao)
    {
        this.userJpaDao = userJpaDao;
    }

    @Override
    public User findUserById(Integer userId)
    {
        return userJpaDao.findOne(userId);
    }

    @Override
    public Student registerStudent(Student student)
    {
        User user = student;
        userJpaDao.save(user);
        return studentJpaDao.save(student);
    }

    @Override
    public List<User> findAll()
    {
        return userJpaDao.findAll();
    }
}