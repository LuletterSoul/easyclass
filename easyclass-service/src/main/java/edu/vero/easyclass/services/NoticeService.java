package edu.vero.easyclass.services;


import edu.vero.easyclass.domain.Notice;


public interface NoticeService
{
    Notice updateNotice(Notice notice);

    Notice findNotice(Integer noticeId);

    Notice deleteNotice(Integer noticeId);

    Notice createNotice(Notice notice);
}
