package edu.vero.easyclass.services;

import edu.vero.easyclass.domain.*;

import java.util.List;

public interface ClassScheduleService {
    public Homework updateHomework(String scheduled,Homework homework);
    public List<ClassSchedule> findAll();
    public List<TestRecord> findAllTestRecords(String scheduleId);
    public List<SignRecord> findAllSignRecords(String scheduleId);
    public List<Attendance> findAllAttendances(String scheduleId);
    public List<Homework> findAllHomeworks(String scheduleId);
    public TeacherArrangement findArrangement(String schduleId);
    public Student findStudent(String schduleId);
}
