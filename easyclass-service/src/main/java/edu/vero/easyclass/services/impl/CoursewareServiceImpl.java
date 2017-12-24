package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.Courseware;
import edu.vero.easyclass.repositories.CoursewareJpaDao;
import edu.vero.easyclass.services.CoursewareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CoursewareServiceImpl implements CoursewareService
{

    private CoursewareJpaDao coursewareJpaDao;

    @Autowired
    public void setCoursewareJpaDao(CoursewareJpaDao coursewareJpaDao)
    {
        this.coursewareJpaDao = coursewareJpaDao;
    }

    @Override
    public List<Courseware> findAllCourseWare()
    {
        return coursewareJpaDao.findAll();
    }

    @Override
    public Courseware findCourseWare(Integer coursewareId)
    {
        Courseware courseware = coursewareJpaDao.findOne(coursewareId);
        return courseware;
    }

    @Override
    public Courseware createCourseware(Courseware courseware)
    {
        coursewareJpaDao.saveAndFlush(courseware);
        return courseware;
    }

    @Override
    public Courseware deleteCourseware(Integer CoursewareId)
    {
        Courseware courseware = coursewareJpaDao.findOne(CoursewareId);
        coursewareJpaDao.delete(courseware);
        return courseware;
    }

    @Override
    public Courseware updateCourseware(Courseware courseware)
    {
        coursewareJpaDao.saveAndFlush(courseware);
        return courseware;
    }
}
