package edu.vero.easyclass.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="class_schedule")
public class ClassSchedule {

    @GeneratedValue(generator = "scheduleId",strategy = GenerationType.IDENTITY)
    private int scheduleId;
    private Student student;
    private TeacherArragement teacherArragement;
    private Set<OnlineClassTest> tests;
    private Set<Homework> homeworks;
    private Set<Attendance> attendances;

    @Id
    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    @ManyToOne
    @JoinColumn(name="studentId")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    @ManyToOne
    @JoinColumn(name="arragId")
    public TeacherArragement getTeacherArragement() {
        return teacherArragement;
    }

    public void setTeacherArragement(TeacherArragement teacherArragement) {
        this.teacherArragement = teacherArragement;
    }
    @OneToMany
    @JoinColumn(name="scheduleId")
    public Set<OnlineClassTest> getOnlineClassTestSet() {
        return tests;
    }

    public void setOnlineClassTestSet(Set<OnlineClassTest> onlineClassTestSet) {
        this.tests = onlineClassTestSet;
    }
    @OneToMany
    @JoinColumn(name="scheduleId")
    public Set<Homework> getHomeworks() {
        return homeworks;
    }

    public void setHomeworks(Set<Homework> homeworks) {
        this.homeworks = homeworks;
    }

    @OneToMany
    @JoinColumn(name="scheduleId")
    public Set<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(Set<Attendance> attendances) {
        this.attendances = attendances;
    }
}
