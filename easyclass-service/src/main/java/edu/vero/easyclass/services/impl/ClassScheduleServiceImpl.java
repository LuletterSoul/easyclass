package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.*;
import edu.vero.easyclass.repositories.*;
import edu.vero.easyclass.services.ClassScheduleService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 18:30 2017/12/16.
 * @since easyclass
 */

@Service
public class ClassScheduleServiceImpl implements ClassScheduleService
{

    private ClassScheduleJpaDao scheduleJpaDao;

    private HomeworkJpaDao homeworkJpaDao;

    private StudentJpaDao studentJpaDao;

    private TeacherArrangementJpaDao arrangementJpaDao;

    private OnlineClassTestJpaDao onlineClassTestJpaDao;

    private TestsJpaDao testsJpaDao;

    private TestRecordJpaDao testRecordJpaDao;

    @Autowired
    public ClassScheduleServiceImpl(ClassScheduleJpaDao scheduleJpaDao,
                                    HomeworkJpaDao homeworkJpaDao, StudentJpaDao studentJpaDao,
                                    TeacherArrangementJpaDao arrangementJpaDao,
                                    OnlineClassTestJpaDao onlineClassTestJpaDao,
                                    TestsJpaDao testsJpaDao, TestRecordJpaDao testRecordJpaDao)
    {
        this.scheduleJpaDao = scheduleJpaDao;
        this.homeworkJpaDao = homeworkJpaDao;
        this.studentJpaDao = studentJpaDao;
        this.arrangementJpaDao = arrangementJpaDao;
        this.onlineClassTestJpaDao = onlineClassTestJpaDao;
        this.testsJpaDao = testsJpaDao;
        this.testRecordJpaDao = testRecordJpaDao;
    }

    @Override
    public Homework uploadHomework(Integer scheduled, Integer homeworkId,
                                   MultipartFile multipartFile)
    {
//        ServletContext context = ContextLoader.getCurrentWebApplicationContext().getServletContext();
//        // 获取应用部署到服务器之后的应用上下文，为文件保存的路径做基础规划；
//        String relativePath = "\\schedules\\" + scheduled + "\\homeworks";
//        String realPath = context.getRealPath(relativePath);
//        try
//        {
//            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), new File(realPath));
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        String fileName = multipartFile.getOriginalFilename();
//        Homework homework = homeworkJpaDao.findOne(homeworkId);
        return null;
    }

    @Override
    public List<ClassSchedule> findAll()
    {
        return scheduleJpaDao.findAll();
    }

    @Override
    public List<OnlineClassTest> findAllTests(Integer scheduleId) {
        ClassSchedule schedule = scheduleJpaDao.findOne(scheduleId);
        return new ArrayList<>(schedule.getTeacherArrangement().getTests());
    }

    @Override
    public List<OnlineClassTest> findTestIsExpectedDone(Integer scheduleId)
    {
        ClassSchedule classSchedule = scheduleJpaDao.findOne(scheduleId);
        if (classSchedule == null)
        {
            throw new EntityNotFoundException(
                "Required / requested " + "class schedule " + scheduleId + " not found.");
        }
        Set<TestRecord> records = classSchedule.getTestRecords();
        // 获取学生该门所有已经签到的记录ID
        List<Integer> doneTestIds = new ArrayList<>();
        for (TestRecord record : records)
        {
            doneTestIds.add(record.getTest().getTestId());
        }
        // 获取该门课发起所有的课堂测试
        Set<OnlineClassTest> echoedTests = classSchedule.getTeacherArrangement().getTests();
        List<Integer> echoedTestIds = new ArrayList<>();
        for (OnlineClassTest test : echoedTests)
        {
            echoedTestIds.add(test.getTestId());
        }
        return onlineClassTestJpaDao.findByTestIdNotInAndTestIdIn(doneTestIds, echoedTestIds);
    }

    @Override
    public List<OnlineClassTest> findTestsIsDone(Integer scheduleId)
    {
        ClassSchedule classSchedule = scheduleJpaDao.findOne(scheduleId);
        if (classSchedule == null)
        {
            throw new EntityNotFoundException(
                "Required / requested " + "schedule " + scheduleId + " not found.");
        }
        Set<TestRecord> records = classSchedule.getTestRecords();
        List<OnlineClassTest> tests = new ArrayList<>();
        for (TestRecord record : records)
        {
            tests.add(record.getTest());
        }
        return tests;
    }

    @Override
    public List<TestRecord> findAllTestRecords(Integer scheduleId)
    {
        return new ArrayList<TestRecord>(scheduleJpaDao.findOne(scheduleId).getTestRecords());
    }

    @Override
    public List<SignRecord> findAllSignRecords(Integer scheduleId)
    {
        return new ArrayList<SignRecord>(scheduleJpaDao.findOne(scheduleId).getSignRecords());
    }

    @Override
    public TestRecord createTestRecord(Integer scheduleId, TestRecord testRecord)
    {
        ClassSchedule schedule = new ClassSchedule();
        schedule.setScheduleId(scheduleId);
        testRecord.setSchedule(schedule);
        return testRecordJpaDao.saveAndFlush(testRecord);
    }

    // @Override
    // public List<Attendance> findAllAttendances(Integer scheduleId)
    // {
    // return new ArrayList<Attendance>(scheduleJpaDao.findOne(scheduleId).getAttendances());
    // }

    @Override
    public List<Homework> findAllHomeworks(Integer scheduleId)
    {
        return new ArrayList<Homework>(scheduleJpaDao.findOne(scheduleId).getTeacherArrangement().getHomeworks());
    }

    @Override
    public TeacherArrangement findArrangement(Integer scheduleId)
    {
        return scheduleJpaDao.findOne(scheduleId).getTeacherArrangement();
    }

    @Override
    public Student findStudent(Integer scheduleId)
    {
        return scheduleJpaDao.findOne(scheduleId).getStudent();
    }

    @Override
    public ClassSchedule deleteSchedule(Integer scheduleId)
    {
        ClassSchedule schedule = scheduleJpaDao.findOne(scheduleId);
        scheduleJpaDao.delete(scheduleId);
        return schedule;
    }

    @Override
    public ClassSchedule createSchedule(Integer userId, Integer arrangeId)
    {
        ClassSchedule classSchedule = new ClassSchedule();
        Student student = studentJpaDao.findOne(userId);
        TeacherArrangement arrangement = arrangementJpaDao.findOne(arrangeId);
        if (student == null || arrangement == null)
        {
            throw new EntityNotFoundException(
                "student " + userId + "or arrangement " + arrangeId + " not found.");
        }
        classSchedule.setTeacherArrangement(arrangement);
        classSchedule.setStudent(student);
        return scheduleJpaDao.saveAndFlush(classSchedule);
    }
}
