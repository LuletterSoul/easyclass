package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.ClassSchedule;
import edu.vero.easyclass.domain.CourseComment;
import edu.vero.easyclass.domain.TeacherArrangement;
import edu.vero.easyclass.repositories.ClassScheduleJpaDao;
import edu.vero.easyclass.repositories.CourseCommentJpaDao;
import edu.vero.easyclass.repositories.TeacherArrangementJpaDao;
import edu.vero.easyclass.services.CourseCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseCommentServiceImpl implements CourseCommentService
{
    private CourseCommentJpaDao courseCommentJpaDao;

    private TeacherArrangementJpaDao teacherArrangementJpaDao;

    private ClassScheduleJpaDao scheduleJpaDao;

    @Autowired
    public void setScheduleJpaDao(ClassScheduleJpaDao scheduleJpaDao)
    {
        this.scheduleJpaDao = scheduleJpaDao;
    }

    @Autowired
    public void setTeacherArrangementJpaDao(TeacherArrangementJpaDao teacherArrangementJpaDao)
    {
        this.teacherArrangementJpaDao = teacherArrangementJpaDao;
    }

    @Autowired
    public void setCourseCommentJpaDao(CourseCommentJpaDao courseCommentJpaDao)
    {
        this.courseCommentJpaDao = courseCommentJpaDao;
    }

    @Override
    public CourseComment save(Integer arrangeId, Integer scheduleId, CourseComment comment)
    {
        TeacherArrangement teacherArrangement = new TeacherArrangement();
        teacherArrangement.setArrangementId(arrangeId);
        ClassSchedule classSchedule = new ClassSchedule();
        classSchedule.setScheduleId(scheduleId);
        comment.setArrangement(teacherArrangement);
        comment.setSchedule(classSchedule);
        classSchedule.setCourseComment(comment);
        courseCommentJpaDao.saveAndFlush(comment);
        scheduleJpaDao.saveAndFlush(classSchedule);
        return comment;
    }
}
