package edu.vero.easyclass.services.impl;

import edu.vero.easyclass.domain.Homework;
import edu.vero.easyclass.repositories.HomeworkJpaDao;
import edu.vero.easyclass.services.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkServiceImpl implements HomeworkService {

    private HomeworkJpaDao homeworkJpaDao;

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
    public List<Homework> findAllHomeworks() {
        List<Homework> list=homeworkJpaDao.findAll();
        return list;
    }
}
