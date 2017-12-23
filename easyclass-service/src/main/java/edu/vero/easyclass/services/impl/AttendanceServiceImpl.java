package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.*;
import edu.vero.easyclass.repositories.*;
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

    private VoteOptionJpaDao voteOptionJpaDao;

    @Autowired
    public AttendanceServiceImpl(VoteJpaDao voteJpaDao, AttendanceJpaDao attendanceJpaDao,
                                 QRcodeJpaDao qRcodeJpaDao,
                                 TeacherArrangementJpaDao arrangementJpaDao,
                                 VoteOptionJpaDao voteOptionJpaDao)
    {
        this.voteJpaDao = voteJpaDao;
        this.attendanceJpaDao = attendanceJpaDao;
        this.qRcodeJpaDao = qRcodeJpaDao;
        this.arrangementJpaDao = arrangementJpaDao;
        this.voteOptionJpaDao = voteOptionJpaDao;
    }

    @Override
    public Vote createVote(Integer attendanceId, Vote vote)
    {
        Attendance attendance = attendanceJpaDao.findOne(attendanceId);
        Date date = new Date();
        vote.setEstablishedTime(date);
        vote.setAttendance(attendance);
        voteJpaDao.save(vote);
        Set<VoteOption> voteOptions = vote.getOptions();
        for (VoteOption option :
                voteOptions) {
            option.setVote(vote);
        }
        voteOptionJpaDao.save(voteOptions);
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
    public Attendance createAttendance(Attendance attendance)
    {
        return attendanceJpaDao.save(attendance);
    }

    @Override
    public Attendance deleteAttendance(Integer attendanceId)
    {
        Attendance attendance = attendanceJpaDao.findOne(attendanceId);
        attendanceJpaDao.delete(attendance);
        return attendance;
    }

}
