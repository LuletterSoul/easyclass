package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.*;
import edu.vero.easyclass.repositories.*;
import edu.vero.easyclass.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    private SignRecordJpaDao signRecordJpaDao;

    private ClassScheduleJpaDao classScheduleJpaDao;

    private TestsJpaDao testsJpaDao;

    @Autowired
    public AttendanceServiceImpl(VoteJpaDao voteJpaDao, AttendanceJpaDao attendanceJpaDao,
                                 QRcodeJpaDao qRcodeJpaDao,
                                 TeacherArrangementJpaDao arrangementJpaDao,
                                 VoteOptionJpaDao voteOptionJpaDao,
                                 SignRecordJpaDao signRecordJpaDao,
                                 ClassScheduleJpaDao classScheduleJpaDao, TestsJpaDao testsJpaDao)
    {
        this.voteJpaDao = voteJpaDao;
        this.attendanceJpaDao = attendanceJpaDao;
        this.qRcodeJpaDao = qRcodeJpaDao;
        this.arrangementJpaDao = arrangementJpaDao;
        this.voteOptionJpaDao = voteOptionJpaDao;
        this.signRecordJpaDao = signRecordJpaDao;
        this.classScheduleJpaDao = classScheduleJpaDao;
        this.testsJpaDao = testsJpaDao;
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
        for (VoteOption option : voteOptions)
        {
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
    public Attendance updateAttendance(Integer attendanceId)
    {
        Attendance attendance = attendanceJpaDao.findOne(attendanceId);
        attendance.setClosed(true);
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
        TeacherArrangement teacherArrangement = arrangementJpaDao.findOne(
            attendance.getArrangement().getArrangementId());
        QRcode qRcode = qRcodeJpaDao.findOne(attendance.getqRcode().getCodeId());
        attendance.setArrangement(teacherArrangement);
        attendance.setqRcode(qRcode);
        attendance.setEstablishedTime(new Date());
        return attendanceJpaDao.save(attendance);
    }

    @Override
    public Attendance deleteAttendance(Integer attendanceId)
    {
        Attendance attendance = attendanceJpaDao.findOne(attendanceId);
        attendanceJpaDao.delete(attendance);
        return attendance;
    }

    @Override
    public List<Vote> findVotes(Integer attendanceId)
    {
        return new ArrayList<>(attendanceJpaDao.findOne(attendanceId).getVotes());
    }

    @Override
    public SignRecord createSignRecord(Integer attendanceId, Integer scheduleId)
    {
        SignRecord signRecord = new SignRecord();
        ClassSchedule classSchedule = classScheduleJpaDao.findOne(attendanceId);
        Set<SignRecord> currentSignRecords = classSchedule.getSignRecords();
        // 判断是否已经签到;
        for (SignRecord record : currentSignRecords)
        {
            if (record.getAttendance().getAttendanceId() == attendanceId)
            {
                throw new DataIntegrityViolationException(
                    "you has already signed in this attendance.Please don't sign repeatedly.");
            }
        }
        // 未签到
        Attendance attendance = new Attendance();
        signRecord.setSignTime(new Date());
        attendance.setAttendanceId(attendanceId);
        signRecord.setAttendance(attendance);
        signRecordJpaDao.saveAndFlush(signRecord);
        return signRecord;
    }

    @Override
    public Vote findNewestVote(Integer attendanceId)
    {
        List<Vote> newestVote = voteJpaDao.findNewestVote(attendanceId);
        if (newestVote == null) {
            throw new EntityNotFoundException();
        }
        return voteJpaDao.findNewestVote(attendanceId).get(0);
    }
}
