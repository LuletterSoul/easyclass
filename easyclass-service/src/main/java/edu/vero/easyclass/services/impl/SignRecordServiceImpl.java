package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.Attendance;
import edu.vero.easyclass.domain.ClassSchedule;
import edu.vero.easyclass.domain.SignRecord;
import edu.vero.easyclass.repositories.SignRecordJpaDao;
import edu.vero.easyclass.services.SignRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SignRecordServiceImpl implements SignRecordService
{

    private SignRecordJpaDao signRecordJpaDao;

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
