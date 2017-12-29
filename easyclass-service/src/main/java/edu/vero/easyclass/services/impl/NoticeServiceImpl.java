package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.Notice;
import edu.vero.easyclass.repositories.NoticeJpaDao;
import edu.vero.easyclass.services.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 18:41 2017/12/16.
 * @since easyclass
 */

@Service
public class NoticeServiceImpl implements NoticeService
{

    private NoticeJpaDao noticeJpaDao;

    @Autowired
    public void setNoticeJpaDao(NoticeJpaDao noticeJpaDao)
    {
        this.noticeJpaDao = noticeJpaDao;
    }

    @Override
    public Notice updateNotice(Notice notice)
    {
        return noticeJpaDao.save(notice);
    }

    @Override
    public Notice findNotice(Integer noticeId)
    {
        return noticeJpaDao.findOne(noticeId);
    }

    @Override
    public Notice deleteNotice(Integer noticeId)
    {
        Notice notice = noticeJpaDao.findOne(noticeId);
        noticeJpaDao.delete(notice);
        return notice;
    }

    @Override
    public Notice createNotice(Notice notice) {
        notice.setEstablishedTime(new Date());
        return noticeJpaDao.saveAndFlush(notice);
    }
}
