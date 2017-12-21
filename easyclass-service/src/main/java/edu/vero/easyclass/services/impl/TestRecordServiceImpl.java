package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.ClassSchedule;
import edu.vero.easyclass.domain.OnlineClassTest;
import edu.vero.easyclass.domain.TestRecord;
import edu.vero.easyclass.repositories.ScheduleJpaDao;
import edu.vero.easyclass.repositories.TestRecordJpaDao;
import edu.vero.easyclass.repositories.TestsJpaDao;
import edu.vero.easyclass.services.TestRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TestRecordServiceImpl implements TestRecordService
{

    private TestRecordJpaDao testRecordJpaDao;

    private ScheduleJpaDao scheduleJpaDao;

    private TestsJpaDao testsJpaDao;

    @Autowired
    public void setTestRecordJpaDao(TestRecordJpaDao testRecordJpaDao)
    {
        this.testRecordJpaDao = testRecordJpaDao;
    }

    @Autowired
    public void setScheduleJpaDao(ScheduleJpaDao scheduleJpaDao)
    {
        this.scheduleJpaDao = scheduleJpaDao;
    }

    @Autowired
    public void setTestsJpaDao(TestsJpaDao testsJpaDao)
    {
        this.testsJpaDao = testsJpaDao;
    }

    public List<TestRecord> findAllTestRecords()
    {
        return testRecordJpaDao.findAll();
    }

    public TestRecord createTestRecord(TestRecord testRecord)
    {
        testRecordJpaDao.saveAndFlush(testRecord);
        return testRecord;
    }

    public ClassSchedule findClassSchedule(Integer recordId)
    {
        TestRecord testRecord = testRecordJpaDao.findOne(recordId);
        return testRecord.getSchedule();
    }

    public OnlineClassTest findTest(Integer recordId)
    {
        TestRecord testRecord = testRecordJpaDao.findOne(recordId);
        return testRecord.getTest();
    }

    @Override
    public TestRecord deleteTestRecord(Integer recordId) {
        TestRecord testRecord=testRecordJpaDao.findOne(recordId);
        testRecordJpaDao.delete(testRecord);
        return testRecord;
    }

    @Override
    public TestRecord updateTestRecord(TestRecord question) {
        testRecordJpaDao.saveAndFlush(question);
        return question;
    }

}
