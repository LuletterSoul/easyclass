package edu.vero.easyclass.services;


import edu.vero.easyclass.domain.*;

import java.util.List;


public interface ClassScheduleService
{
    Homework updateHomework(Integer scheduled, Homework homework);

    List<ClassSchedule> findAll();

    List<TestRecord> findAllTestRecords(Integer scheduleId);

    List<SignRecord> findAllSignRecords(Integer scheduleId);

    List<Attendance> findAllAttendances(Integer scheduleId);

    List<Homework> findAllHomeworks(Integer scheduleId);

    TeacherArrangement findArrangement(Integer scheduleId);

    Student findStudent(Integer scheduleId);

    ClassSchedule deleteSchedule(Integer scheduleId);

    ClassSchedule createSchedule(Integer userId,Integer arrangeId,ClassSchedule classSchedule);
}
