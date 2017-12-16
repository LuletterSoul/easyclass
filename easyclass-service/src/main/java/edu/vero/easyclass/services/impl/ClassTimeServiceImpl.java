package edu.vero.easyclass.services.impl;

import edu.vero.easyclass.repositories.ClassTimeJpaDao;
import edu.vero.easyclass.services.ClassTimeService;
import org.springframework.beans.factory.annotation.Autowired;

public class ClassTimeServiceImpl implements ClassTimeService {

    private ClassTimeJpaDao classTimeJpaDao;

    @Autowired
    public void setClassTimeJpaDao(ClassTimeJpaDao classTimeJpaDao) {
        this.classTimeJpaDao = classTimeJpaDao;
    }
}
