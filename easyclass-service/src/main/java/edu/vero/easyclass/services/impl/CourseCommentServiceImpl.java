package edu.vero.easyclass.services.impl;

import edu.vero.easyclass.domain.CourseComment;
import edu.vero.easyclass.repositories.ClassScheduleJpaDao;
import edu.vero.easyclass.repositories.CourseCommentJpaDao;
import edu.vero.easyclass.repositories.TeacherArrangementJpaDao;
import edu.vero.easyclass.services.CourseCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseCommentServiceImpl implements CourseCommentService{
    private CourseCommentJpaDao courseCommentJpaDao;

    private TeacherArrangementJpaDao teacherArrangementJpaDao;

    private ClassScheduleJpaDao scheduleJpaDao;

    @Autowired
    public void setScheduleJpaDao(ClassScheduleJpaDao scheduleJpaDao) {
        this.scheduleJpaDao = scheduleJpaDao;
    }

    @Autowired
    public void setTeacherArrangementJpaDao(TeacherArrangementJpaDao teacherArrangementJpaDao) {
        this.teacherArrangementJpaDao = teacherArrangementJpaDao;
    }

    @Autowired
    public void setCourseCommentJpaDao(CourseCommentJpaDao courseCommentJpaDao) {
        this.courseCommentJpaDao = courseCommentJpaDao;
    }

    @Override
    public CourseComment save(Integer arrangeId, Integer schduleId, CourseComment comment) {
        comment.setArrangement(teacherArrangementJpaDao.findOne(arrangeId));
        comment.setSchedule(scheduleJpaDao.findOne(schduleId));
        return courseCommentJpaDao.saveAndFlush(comment);
    }
}
