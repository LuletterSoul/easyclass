package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.*;
import edu.vero.easyclass.repositories.ClassScheduleJpaDao;
import edu.vero.easyclass.repositories.HomeworkJpaDao;
import edu.vero.easyclass.repositories.StudentJpaDao;
import edu.vero.easyclass.repositories.TeacherArrangementJpaDao;
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

    private StudentJpaDao studentJpaDao;

    private TeacherArrangementJpaDao arrangementJpaDao;

    @Autowired
    public void setArrangementJpaDao(TeacherArrangementJpaDao arrangementJpaDao) {
        this.arrangementJpaDao = arrangementJpaDao;
    }

    @Autowired
    public void setStudentJpaDao(StudentJpaDao studentJpaDao) {
        this.studentJpaDao = studentJpaDao;
    }

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

//    @Override
//    public List<Attendance> findAllAttendances(Integer scheduleId)
//    {
//        return new ArrayList<Attendance>(scheduleJpaDao.findOne(scheduleId).getAttendances());
//    }

    @Override
    public List<Homework> findAllHomeworks(Integer scheduleId)
    {
        return new ArrayList<Homework>(scheduleJpaDao.findOne(scheduleId).getHomeworks());
    }

    @Override
    public TeacherArrangement findArrangement(Integer scheduleId)
    {
        return scheduleJpaDao.findOne(scheduleId).getTeacherArrangement();
    }

    @Override
    public Student findStudent(Integer scheduleId)
    {
        return scheduleJpaDao.findOne(scheduleId).getStudent();
    }

    @Override
    public ClassSchedule deleteSchedule(Integer scheduleId) {
        ClassSchedule schedule = scheduleJpaDao.findOne(scheduleId);
        scheduleJpaDao.delete(scheduleId);
        return schedule;
    }

    @Override
    public ClassSchedule createSchedule(Integer userId, Integer arrangeId, ClassSchedule classSchedule) {
        Student student = studentJpaDao.findOne(userId);
        TeacherArrangement arrangement = arrangementJpaDao.findOne(arrangeId);
        classSchedule.setTeacherArrangement(arrangement);
        classSchedule.setStudent(student);
        return scheduleJpaDao.saveAndFlush(classSchedule);
    }
}
