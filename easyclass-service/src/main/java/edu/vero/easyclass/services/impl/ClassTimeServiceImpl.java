package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.ClassTime;
import edu.vero.easyclass.domain.ClassTimeComment;
import edu.vero.easyclass.domain.TeachingComment;
import edu.vero.easyclass.repositories.ClassTimeCommentJpaDao;
import edu.vero.easyclass.repositories.ClassTimeJpaDao;
import edu.vero.easyclass.repositories.CourseCommentJpaDao;
import edu.vero.easyclass.services.ClassTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class ClassTimeServiceImpl implements ClassTimeService
{

    private ClassTimeJpaDao classTimeJpaDao;

    private ClassTimeCommentJpaDao timeCommentJpaDao;

    @Autowired
    public void setTimeCommentJpaDao(ClassTimeCommentJpaDao timeCommentJpaDao)
    {
        this.timeCommentJpaDao = timeCommentJpaDao;
    }

    @Autowired
    public void setClassTimeJpaDao(ClassTimeJpaDao classTimeJpaDao)
    {
        this.classTimeJpaDao = classTimeJpaDao;
    }

    @Override
    public ClassTime findClassTime(Integer timeId)
    {

        ClassTime classTime = classTimeJpaDao.findOne(timeId);
        return classTime;
    }

    @Override
    public List<ClassTime> findAllClassTimes()
    {
        List<ClassTime> list = classTimeJpaDao.findAll();
        return list;
    }

    @Override
    public ClassTimeComment savePerClassComment(Integer timeId, ClassTimeComment comment)
    {
        ClassTime time = classTimeJpaDao.findOne(timeId);
        timeCommentJpaDao.save(comment);
        return comment;
    }

    @Override
    public List<ClassTimeComment> findAllClassComments(Integer timeId)
    {
        return null;
    }

}
