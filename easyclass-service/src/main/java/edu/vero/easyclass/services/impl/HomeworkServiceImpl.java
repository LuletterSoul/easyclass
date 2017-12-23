package edu.vero.easyclass.services.impl;

import edu.vero.easyclass.domain.ClassSchedule;
import edu.vero.easyclass.domain.Homework;
import edu.vero.easyclass.repositories.HomeworkJpaDao;
import edu.vero.easyclass.repositories.ScheduleJpaDao;
import edu.vero.easyclass.services.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkServiceImpl implements HomeworkService {

    private HomeworkJpaDao homeworkJpaDao;

    private ScheduleJpaDao scheduleJpaDao;

    @Autowired
    public void setScheduleJpaDao(ScheduleJpaDao scheduleJpaDao) {
        this.scheduleJpaDao = scheduleJpaDao;
    }

    @Autowired
    public void setHomeworkJpaDao(HomeworkJpaDao homeworkJpaDao) {
        this.homeworkJpaDao = homeworkJpaDao;
    }

    @Override
    public Homework deleteHomework(Integer homeworkId) {
        Homework homework =homeworkJpaDao.findOne(homeworkId);
        homeworkJpaDao.delete(homework);
        return homework;
    }

    @Override
    public Homework updateHomework( Homework  homework) {

        homeworkJpaDao.saveAndFlush(homework);
        return homework;
    }

    @Override
    public Homework createHomework( Homework  homework) {
        ClassSchedule schedule = scheduleJpaDao.findOne(homework.getSchedule().getScheduleId());
        homework.setSchedule(schedule);
        return homeworkJpaDao.saveAndFlush(homework);
    }

    @Override
    public List<Homework> findAllHomeworks() {
        List<Homework> list=homeworkJpaDao.findAll();
        return list;
    }
}
