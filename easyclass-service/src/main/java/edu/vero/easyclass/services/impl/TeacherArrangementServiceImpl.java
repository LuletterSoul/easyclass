package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.Courseware;
import edu.vero.easyclass.domain.Notice;
import edu.vero.easyclass.domain.TeacherArrangement;
import edu.vero.easyclass.repositories.CoursewareJpaDao;
import edu.vero.easyclass.repositories.NoticeJpaDao;
import edu.vero.easyclass.repositories.TeacherArrangementJpaDao;
import edu.vero.easyclass.services.TeacherArrangementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 0:12 2017/12/15.
 * @since easyclass
 */

@Service
public class TeacherArrangementServiceImpl implements TeacherArrangementService
{

    private TeacherArrangementJpaDao teacherArrangementJpaDao;

    private NoticeJpaDao noticeJpaDao;

    private CoursewareJpaDao coursewareJpaDao;

    @Autowired
    public void setCoursewareJpaDao(CoursewareJpaDao coursewareJpaDao)
    {
        this.coursewareJpaDao = coursewareJpaDao;
    }

    @Autowired
    public void setNoticeJpaDao(NoticeJpaDao noticeJpaDao)
    {
        this.noticeJpaDao = noticeJpaDao;
    }

    @Autowired
    public void setTeacherArrangementJpaDao(TeacherArrangementJpaDao teacherArrangementJpaDao)
    {
        this.teacherArrangementJpaDao = teacherArrangementJpaDao;
    }

    @Override
    public Notice createNotice(Integer arrangementId, Notice notice)
    {
        // 先从数据库里面查找出对应教师安排表
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);
        // 给公告关联对应的教师安排表
        notice.setArrangement(teacherArrangement);
        // 这步可以删去，因为教师安排表中没有对应的公告键
        // teacherArrangement.getNotices().add(notice);
        // 持久化公告
        noticeJpaDao.saveAndFlush(notice);
        teacherArrangementJpaDao.saveAndFlush(teacherArrangement);
        return notice;
    }

    @Override
    public List<TeacherArrangement> findAllArrangements()
    {
        return teacherArrangementJpaDao.findAll();
    }

    @Override
    public List<Courseware> findAllCoursewares(Integer arrangementId)
    {
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);
        return null;
    }
}
