package edu.vero.easyclass.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.MoreObjects;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "class_schedule")
public class ClassSchedule
{

    private int scheduleId;

    private Student student;

    private TeacherArrangement teacherArrangement;

    private CourseComment courseComment;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Set<ClassTimeComment> timeComments;

    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    public int getScheduleId()
    {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId)
    {
        this.scheduleId = scheduleId;
    }

    @OneToOne
    @JoinColumn(name = "commentId")
    public CourseComment getCourseComment()
    {
        return courseComment;
    }

    public void setCourseComment(CourseComment courseComment)
    {
        this.courseComment = courseComment;
    }

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Set<Homework> homeworks;

//    @ApiModelProperty(hidden = true)
//    @JsonIgnore
//    private Set<Attendance> attendances;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Set<TestRecord> testRecords;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Set<SignRecord> signRecords;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    @OneToMany(mappedBy = "schedule")
    public Set<SignRecord> getSignRecords()
    {
        return signRecords;
    }

    public void setSignRecords(Set<SignRecord> signRecords)
    {
        this.signRecords = signRecords;
    }

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    @OneToMany(mappedBy = "schedule")
    public Set<TestRecord> getTestRecords()
    {
        return testRecords;
    }

    public void setTestRecords(Set<TestRecord> testRecords)
    {
        this.testRecords = testRecords;
    }

    @ManyToOne
    @JoinColumn(name = "userId")
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

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    @OneToMany(mappedBy = "schedule")
    public Set<Homework> getHomeworks()
    {
        return homeworks;
    }

    public void setHomeworks(Set<Homework> homeworks)
    {
        this.homeworks = homeworks;
    }

//    @OneToMany
//    @JoinColumn(name = "scheduleId")
//    public Set<Attendance> getAttendances()
//    {
//        return attendances;
//    }
//
//    public void setAttendances(Set<Attendance> attendances)
//    {
//        this.attendances = attendances;
//    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this).add("scheduleId", scheduleId).add("student",
            student).add("teacherArrangement", teacherArrangement).toString();
    }

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    @OneToMany(mappedBy = "classTime")
    public Set<ClassTimeComment> getTimeComments()
    {
        return timeComments;
    }

    public void setTimeComments(Set<ClassTimeComment> timeComments)
    {
        this.timeComments = timeComments;
    }
}
