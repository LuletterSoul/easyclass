package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.*;
import edu.vero.easyclass.repositories.ClassScheduleJpaDao;
import edu.vero.easyclass.repositories.HomeworkJpaDao;
import edu.vero.easyclass.services.ClassScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 18:30 2017/12/16.
 * @since easyclass
 */

@Service
public class ClassScheduleServiceImpl implements ClassScheduleService
{

    private ClassScheduleJpaDao scheduleJpaDao;

    private HomeworkJpaDao homeworkJpaDao;

    @Autowired
    public void setHomeworkJpaDao(HomeworkJpaDao homeworkJpaDao)
    {
        this.homeworkJpaDao = homeworkJpaDao;
    }

    @Autowired
    public void setScheduleJpaDao(ClassScheduleJpaDao scheduleJpaDao)
    {
        this.scheduleJpaDao = scheduleJpaDao;
    }

    @Override
    public Homework updateHomework(Integer scheduled, Homework homework)
    {
        return homeworkJpaDao.save(homework);
    }

    @Override
    public List<ClassSchedule> findAll()
    {
        return scheduleJpaDao.findAll();
    }

    @Override
    public List<TestRecord> findAllTestRecords(Integer scheduleId)
    {
        return new ArrayList<TestRecord>(scheduleJpaDao.findOne(scheduleId).getTestRecords());
    }

    @Override
    public List<SignRecord> findAllSignRecords(Integer scheduleId)
    {
        return new ArrayList<SignRecord>(scheduleJpaDao.findOne(scheduleId).getSignRecords());
    }

    @Override
    public List<Attendance> findAllAttendances(Integer scheduleId)
    {
        return new ArrayList<Attendance>(scheduleJpaDao.findOne(scheduleId).getAttendances());
    }

    @Override
    public List<Homework> findAllHomeworks(Integer scheduleId)
    {
        return new ArrayList<Homework>(scheduleJpaDao.findOne(scheduleId).getHomeworks());
    }

    @Override
    public TeacherArrangement findArrangement(Integer schduleId)
    {
        return scheduleJpaDao.findOne(schduleId).getTeacherArrangement();
    }

    @Override
    public Student findStudent(Integer schduleId)
    {
        return scheduleJpaDao.findOne(schduleId).getStudent();
    }
}
