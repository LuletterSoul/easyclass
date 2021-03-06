package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.TeacherArrangement;
import edu.vero.easyclass.domain.Teacher;
import edu.vero.easyclass.repositories.TeacherArrangementJpaDao;
import edu.vero.easyclass.repositories.TeacherJpaDao;
import edu.vero.easyclass.services.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 23:59 2017/12/14.
 * @since easyclass
 */

@Service
public class TeacherServiceImpl implements TeacherService
{

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherServiceImpl.class);

    private TeacherJpaDao teacherJpaDao;

    private TeacherArrangementJpaDao teacherArrangementJpaDao;

    @Autowired
    public void setTeacherJapDao(TeacherJpaDao teacherJpaDao)
    {
        this.teacherJpaDao = teacherJpaDao;
    }

    @Autowired
    public void setTeacherArrangementJpaDao(TeacherArrangementJpaDao teacherArrangementJpaDao)
    {
        this.teacherArrangementJpaDao = teacherArrangementJpaDao;
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {

        return teacherJpaDao.save(teacher);
    }

    @Override
    public List<Teacher> findAllTeachers()
    {
        return teacherJpaDao.findAll();
    }

    @Override
    public Teacher findTeacher(Integer userId)
    {
        return teacherJpaDao.findOne(userId);
    }

    @Override
    public List findTeacherArrangement(Integer userId)
    {
        Teacher teacher = teacherJpaDao.findOne(userId);
        return (List) new ArrayList(teacher.getArrangementSet());
    }

    @Override
    public List<TeacherArrangement> createTeacherArrangement(Integer userId,
                                                             List<TeacherArrangement> list)
    {
        Teacher teacher = teacherJpaDao.findOne(userId);
        for (int i = 0; i < list.size(); i++ )
        {
            list.get(i).setTeacher(teacher);
            teacherArrangementJpaDao.saveAndFlush(list.get(i));
        }
        teacherJpaDao.saveAndFlush(teacher);
        return list;
    }

    @Override
    public Teacher deleteTeacher(Integer teacherId) {
        Teacher teacher=teacherJpaDao.findOne(teacherId);
        return teacher;
    }

    @Override
    public Teacher updateTeacher(Teacher question) {
        teacherJpaDao.saveAndFlush(question);
        return question;
    }
}
