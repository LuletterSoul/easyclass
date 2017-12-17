package edu.vero.easyclass.services.impl;

import edu.vero.easyclass.domain.ClassTime;
import edu.vero.easyclass.domain.TeacherComment;
import edu.vero.easyclass.repositories.ClassTimeJpaDao;
import edu.vero.easyclass.services.ClassTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassTimeServiceImpl implements ClassTimeService {

    private ClassTimeJpaDao classTimeJpaDao;

    @Autowired
    public void setClassTimeJpaDao(ClassTimeJpaDao classTimeJpaDao) {
        this.classTimeJpaDao = classTimeJpaDao;
    }

    @Override
    public List<TeacherComment> findAllTeacherComment(Integer timeId) {
        return null;
        //未完成！！！！
    }

    @Override
    public ClassTime findClassTime(Integer timeId) {

        ClassTime classTime= classTimeJpaDao.findOne(timeId);
        return classTime;
    }

    @Override
    public List<ClassTime> findAllClassTimes() {
        List<ClassTime> list=classTimeJpaDao.findAll();
        return list;
    }
}
