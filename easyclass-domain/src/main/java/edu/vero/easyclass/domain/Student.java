package edu.vero.easyclass.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="student")
@PrimaryKeyJoinColumn(name="userId")
public class Student extends User{
    private String studentId;
    private String studentName;
    private String studentGender;
    private String majorIn;
    private String grade;
    private Set<ClassSchedule> schedules;
/*
    @OneToMany
    @JoinTable(name ="class_schedule"
            ,joinColumns = @JoinColumn(name = "studentId")
            ,inverseJoinColumns = @JoinColumn(name = "scheduleId"))
    @JoinColumn(name="scheduled")*/
    @OneToMany(mappedBy = "student")
    public Set<ClassSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<ClassSchedule> schedules) {
        this.schedules = schedules;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getMajorIn() {
        return majorIn;
    }

    public void setMajorIn(String majorIn) {
        this.majorIn = majorIn;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

