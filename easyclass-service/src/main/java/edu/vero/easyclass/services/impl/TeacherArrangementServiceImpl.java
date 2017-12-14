package edu.vero.easyclass.services.impl;

import edu.vero.easyclass.domain.Notice;
import edu.vero.easyclass.domain.TeacherArrangement;
import edu.vero.easyclass.repositories.NoticeJpaDao;
import edu.vero.easyclass.repositories.TeacherArrangementJapDao;
import edu.vero.easyclass.repositories.TeacherJapDao;
import edu.vero.easyclass.services.TeacherArrangementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  0:12 2017/12/15.
 * @since easyclass
 */

@Service
public class TeacherArrangementServiceImpl implements TeacherArrangementService {

    private TeacherArrangementJapDao teacherArrangementJapDao;

    private NoticeJpaDao noticeJpaDao;

    @Autowired
    public void setNoticeJpaDao(NoticeJpaDao noticeJpaDao) {
        this.noticeJpaDao = noticeJpaDao;
    }

    @Autowired
    public void setTeacherArrangementJapDao(TeacherArrangementJapDao teacherArrangementJapDao) {
        this.teacherArrangementJapDao = teacherArrangementJapDao;
    }

    @Override
    public Notice createNotice(Integer arrangementId, Notice notice) {
        //先从数据库里面查找出对应教师安排表
        TeacherArrangement teacherArrangement =teacherArrangementJapDao.findOne(arrangementId);
        //给公告关联对应的教师安排表
        notice.setArrangement(teacherArrangement);
        //这步可以删去，因为教师安排表中没有对应的公告键
//        teacherArrangement.getNotices().add(notice);
        //持久化公告
        noticeJpaDao.save(notice);
        teacherArrangementJapDao.saveAndFlush(teacherArrangement);
        return notice;
    }
}
