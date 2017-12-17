package edu.vero.easyclass.services;

import edu.vero.easyclass.domain.*;

import java.util.List;

public interface ClassScheduleService {
    public Homework updateHomework(String scheduled,Homework homework);
    public List<ClassSchedule> findAll();
    public List<TestRecord> findAllTestRecords(Integer scheduleId);
    public List<SignRecord> findAllSignRecords(Integer scheduleId);
    public List<Attendance> findAllAttendances(Integer scheduleId);
    public List<Homework> findAllHomeworks(Integer scheduleId);
    public TeacherArrangement findArrangement(Integer schduleId);
    public Student findStudent(Integer schduleId);
}
