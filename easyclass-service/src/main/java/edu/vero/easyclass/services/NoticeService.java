package edu.vero.easyclass.services;

import edu.vero.easyclass.domain.Notice;

public interface NoticeService {
    public Notice updateNotice(Notice notice);
    public Notice findNotice(String noticeId);
    public Notice deleteNotice(String noticeId);
}
