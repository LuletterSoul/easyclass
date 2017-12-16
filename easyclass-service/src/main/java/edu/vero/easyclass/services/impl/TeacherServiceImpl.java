package edu.vero.easyclass.services.impl;

import edu.vero.easyclass.domain.Notice;
import edu.vero.easyclass.domain.Teacher;
import edu.vero.easyclass.repositories.TeacherJpaDao;
import edu.vero.easyclass.services.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  23:59 2017/12/14.
 * @since easyclass
 */

@Service
public class TeacherServiceImpl implements TeacherService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherServiceImpl.class);

    private TeacherJpaDao teacherJpaDao;

    @Autowired
    public void setTeacherJpaDao(TeacherJpaDao teacherJpaDao) {
        this.teacherJpaDao = teacherJpaDao;
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        this.teacherJpaDao.save(teacher);
        LOGGER.warn("Persistence Teacher is {}.",teacher.toString());
        return teacher;
    }

    @Override
    public Notice createNotice(Integer userId, Integer arrangementId, Notice notice) {
        return null;
    }
}

