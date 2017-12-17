package edu.vero.easyclass.services;


import edu.vero.easyclass.domain.Notice;


public interface NoticeService
{
    public Notice updateNotice(Notice notice);

    public Notice findNotice(Integer noticeId);

    public Notice deleteNotice(Integer noticeId);
}
