package edu.vero.easyclass.services.impl;

import edu.vero.easyclass.repositories.HomeworkJpaDao;
import edu.vero.easyclass.services.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;

public class HomeworkServiceImpl implements HomeworkService {

    private HomeworkJpaDao homeworkJpaDao;

    @Autowired
    public void setHomeworkJpaDao(HomeworkJpaDao homeworkJpaDao) {
        this.homeworkJpaDao = homeworkJpaDao;
    }
}
