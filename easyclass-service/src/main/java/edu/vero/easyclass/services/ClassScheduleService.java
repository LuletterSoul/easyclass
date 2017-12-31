package edu.vero.easyclass.services;


import edu.vero.easyclass.domain.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ClassScheduleService
{
    Homework uploadHomework(Integer scheduled, Integer homeworkId, MultipartFile multipartFile);

    List<ClassSchedule> findAll();

    List<HomeworkRecord> findHomeworkRecords(Integer scheduleId);

    List<OnlineClassTest> findAllTests(Integer scheduleId);

    List<OnlineClassTest> findTestIsExpectedDone(Integer scheduleId);

    List<OnlineClassTest> findTestsIsDone(Integer scheduleId);

    List<TestRecord> findAllTestRecords(Integer scheduleId);

    List<SignRecord> findAllSignRecords(Integer scheduleId);

    TestRecord createTestRecord(Integer scheduleId, TestRecord testRecord);

//    List<Attendance> findAllAttendances(Integer scheduleId);

    List<Homework> findAllHomeworks(Integer scheduleId);

    TeacherArrangement findArrangement(Integer scheduleId);

    Student findStudent(Integer scheduleId);

    ClassSchedule deleteSchedule(Integer scheduleId);

    ClassSchedule createSchedule(Integer userId,Integer arrangeId);
}
