package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.*;
import edu.vero.easyclass.repositories.AttendanceJpaDao;
import edu.vero.easyclass.repositories.QRcodeJpaDao;
import edu.vero.easyclass.repositories.TeacherArrangementJpaDao;
import edu.vero.easyclass.repositories.VoteJpaDao;
import edu.vero.easyclass.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 18:39 2017/12/16.
 * @since easyclass
 */

@Service
public class AttendanceServiceImpl implements AttendanceService
{
    private VoteJpaDao voteJpaDao;

    private AttendanceJpaDao attendanceJpaDao;

    private QRcodeJpaDao qRcodeJpaDao;

    private TeacherArrangementJpaDao arrangementJpaDao;

    @Autowired
    public void setArrangementJpaDao(TeacherArrangementJpaDao arrangementJpaDao) {
        this.arrangementJpaDao = arrangementJpaDao;
    }

    @Autowired
    public void setqRcodeJpaDao(QRcodeJpaDao qRcodeJpaDao)
    {
        this.qRcodeJpaDao = qRcodeJpaDao;
    }

    @Autowired
    public void setVoteJpaDao(VoteJpaDao voteJpaDao)
    {
        this.voteJpaDao = voteJpaDao;
    }

    @Autowired
    public void setAttendanceJpaDao(AttendanceJpaDao attendanceJpaDao)
    {
        this.attendanceJpaDao = attendanceJpaDao;
    }

    @Override
    public Vote createVote(Integer attendanceId, Vote vote)
    {
        Attendance attendance = attendanceJpaDao.findOne(attendanceId);
        Date date = new Date();
        vote.setEstablishedTime(date);
        vote.setAttendance(attendance);
        voteJpaDao.save(vote);
        return vote;
    }

    @Override
    public QRcode deleteQRcode(Integer attendanceId)
    {
        Attendance attendance = attendanceJpaDao.findOne(attendanceId);
        QRcode qRcode = attendance.getqRcode();
        qRcodeJpaDao.delete(qRcode);
        return qRcode;
    }

    @Override
    public QRcode findQRcode(Integer attendanceId)
    {
        Attendance attendance = attendanceJpaDao.findOne(attendanceId);
        QRcode qRcode = attendance.getqRcode();
        return qRcode;
    }

    @Override
    public Attendance updateAttendance(Attendance attendance)
    {
        return attendanceJpaDao.save(attendance);
    }

    @Override
    public List<SignRecord> findSignRecords(Integer attendanceId)
    {
        Attendance attendance = attendanceJpaDao.findOne(attendanceId);
        Set<SignRecord> signRecordSet = attendance.getSignRecords();
        return new ArrayList<SignRecord>(signRecordSet);
    }

    @Override
    public Attendance createAttendance(Attendance attendance,Integer arrangeId) {
        attendance.setArrangement(arrangementJpaDao.findOne(arrangeId));
        return attendanceJpaDao.saveAndFlush(attendance);
    }

    @Override
    public Attendance deleteAttendance(Integer attendanceId) {
        Attendance attendance =  attendanceJpaDao.findOne(attendanceId);
        attendanceJpaDao.delete(attendance);
        return attendance;
    }
}
