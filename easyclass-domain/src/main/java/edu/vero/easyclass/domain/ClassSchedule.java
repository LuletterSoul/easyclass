package edu.vero.easyclass.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "class_schedule")
public class ClassSchedule
{

    @GeneratedValue(generator = "scheduleId", strategy = GenerationType.IDENTITY)
    private int scheduleId;

    private Student student;

    private TeacherArrangement teacherArrangement;

    private TeacherComment teacherComment;

    @OneToOne
    @JoinColumn(name="commentId")
    public TeacherComment getTeacherComment() {
        return teacherComment;
    }

    public void setTeacherComment(TeacherComment teacherComment) {
        this.teacherComment = teacherComment;
    }

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Set<Homework> homeworks;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Set<Attendance> attendances;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Set<TestRecord> testRecords;

    @ApiModelProperty
    @JsonIgnore
    private Set<SignRecord> signRecords;

    @OneToMany(mappedBy = "schedule")
    public Set<SignRecord> getSignRecords()
    {
        return signRecords;
    }

    public void setSignRecords(Set<SignRecord> signRecords)
    {
        this.signRecords = signRecords;
    }

    @OneToMany(mappedBy = "schedule")
    public Set<TestRecord> getTestRecords()
    {
        return testRecords;
    }

    public void setTestRecords(Set<TestRecord> testRecords)
    {
        this.testRecords = testRecords;
    }

    @Id
    @GenericGenerator(name = "identityGenerator", strategy = "identity")
    @GeneratedValue(generator = "identityGenerator")
    public int getScheduleId()
    {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId)
    {
        this.scheduleId = scheduleId;
    }

    @ManyToOne
    @JoinColumn(name = "studentId")
    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
    }

    @ManyToOne
    @JoinColumn(name = "arrangeId")
    public TeacherArrangement getTeacherArrangement()
    {
        return teacherArrangement;
    }

    public void setTeacherArrangement(TeacherArrangement teacherArrangement)
    {
        this.teacherArrangement = teacherArrangement;
    }

    @OneToMany
    @JoinColumn(name = "scheduleId")
    public Set<Homework> getHomeworks()
    {
        return homeworks;
    }

    public void setHomeworks(Set<Homework> homeworks)
    {
        this.homeworks = homeworks;
    }

    @OneToMany
    @JoinColumn(name = "scheduleId")
    public Set<Attendance> getAttendances()
    {
        return attendances;
    }

    public void setAttendances(Set<Attendance> attendances)
    {
        this.attendances = attendances;
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this).add("scheduleId", scheduleId).add("student",
            student).add("teacherArrangement", teacherArrangement).toString();
    }
}
