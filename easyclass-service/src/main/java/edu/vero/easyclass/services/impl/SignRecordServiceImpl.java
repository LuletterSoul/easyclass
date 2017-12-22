package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.Attendance;
import edu.vero.easyclass.domain.ClassSchedule;
import edu.vero.easyclass.domain.SignRecord;
import edu.vero.easyclass.repositories.AttendanceJpaDao;
import edu.vero.easyclass.repositories.ClassScheduleJpaDao;
import edu.vero.easyclass.repositories.SignRecordJpaDao;
import edu.vero.easyclass.services.SignRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SignRecordServiceImpl implements SignRecordService
{

    private SignRecordJpaDao signRecordJpaDao;

    private AttendanceJpaDao attendanceJpaDao;
    private ClassScheduleJpaDao classScheduleJpaDao;

    @Autowired
    public void setAttendanceJpaDao(AttendanceJpaDao attendanceJpaDao){
        this.attendanceJpaDao=attendanceJpaDao;
    }

    @Autowired
    public void setClassScheduleJpaDao(ClassScheduleJpaDao classScheduleJpaDao){
        this.classScheduleJpaDao=classScheduleJpaDao;
    }

    @Autowired
    public void setSignRecordJpaDao(SignRecordJpaDao signRecordJpaDao)
    {
        this.signRecordJpaDao = signRecordJpaDao;
    }

    @Override
    public List<SignRecord> findAllSignRecord()
    {
        return signRecordJpaDao.findAll();
    }

    @Override
    public Attendance findAttendance(Integer signId)
    {
        SignRecord signRecord = signRecordJpaDao.findOne(signId);
        return signRecord.getAttendance();
    }

    @Override
    public ClassSchedule findClassSchedule(Integer signId)
    {
        SignRecord signRecord = signRecordJpaDao.findOne(signId);
        return signRecord.getSchedule();
    }

    @Override
    public SignRecord createSignRecord(SignRecord signRecord) {
        ClassSchedule classSchedule=classScheduleJpaDao.findOne(signRecord.getSchedule().getScheduleId());
        Attendance attendance=attendanceJpaDao.findOne(signRecord.getAttendance().getAttendanceId());
        signRecord.setAttendance(attendance);
        signRecord.setSchedule(classSchedule);
       signRecordJpaDao.saveAndFlush(signRecord);

        return signRecord;
    }

    @Override
    public SignRecord deleteSignRecord(Integer signrecordId) {
        SignRecord signRecord=signRecordJpaDao.findOne(signrecordId);
        return signRecord;
    }

    @Override
    public SignRecord updateSignRecord(SignRecord courseware) {
        signRecordJpaDao.saveAndFlush(courseware);
        return courseware;
    }
}
