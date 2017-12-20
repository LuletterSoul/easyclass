package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.ClassSchedule;
import edu.vero.easyclass.domain.ClassTime;
import edu.vero.easyclass.domain.ClassTimeComment;
import edu.vero.easyclass.repositories.ClassScheduleJpaDao;
import edu.vero.easyclass.repositories.ClassTimeCommentJpaDao;
import edu.vero.easyclass.repositories.ClassTimeJpaDao;
import edu.vero.easyclass.repositories.ScheduleJpaDao;
import edu.vero.easyclass.services.ClassCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClassCommentServiceImpl implements ClassCommentService
{
    private ClassTimeCommentJpaDao classTimeCommentJpaDao;

    private ClassTimeJpaDao classTimeJpaDao;

    private ClassScheduleJpaDao classScheduleJpaDao;

    @Autowired
    public void setClassScheduleJpaDao(ClassScheduleJpaDao classScheduleJpaDao)
    {
        this.classScheduleJpaDao = classScheduleJpaDao;
    }

    @Autowired
    public void setClassTimeJpaDao(ClassTimeJpaDao classTimeJpaDao)
    {
        this.classTimeJpaDao = classTimeJpaDao;
    }

    @Autowired
    public void setClassTimeCommentJpaDao(ClassTimeCommentJpaDao classTimeCommentJpaDao)
    {
        this.classTimeCommentJpaDao = classTimeCommentJpaDao;
    }

    @Override
    public ClassTimeComment save(Integer timeId, Integer scheduleId, ClassTimeComment comment)
    {
        comment.setClassTime(classTimeJpaDao.findOne(timeId));
        comment.setSchedule(classScheduleJpaDao.findOne(scheduleId));
        return classTimeCommentJpaDao.saveAndFlush(comment);
    }
}
