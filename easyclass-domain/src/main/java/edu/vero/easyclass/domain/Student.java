package edu.vero.easyclass.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Set;


@Entity
@DiscriminatorValue(value = "Student")
public class Student extends User
{
    private String studentId;

    private String studentName;

    private String studentGender;

    private String majorIn;

    private String grade;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Set<ClassSchedule> schedules;

    @OneToMany(mappedBy = "student")
    public Set<ClassSchedule> getSchedules()
    {
        return schedules;
    }

    public void setSchedules(Set<ClassSchedule> schedules)
    {
        this.schedules = schedules;
    }

    public String getStudentId()
    {
        return studentId;
    }

    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public String getStudentGender()
    {
        return studentGender;
    }

    public void setStudentGender(String studentGender)
    {
        this.studentGender = studentGender;
    }

    public String getMajorIn()
    {
        return majorIn;
    }

    public void setMajorIn(String majorIn)
    {
        this.majorIn = majorIn;
    }

    public String getGrade()
    {
        return grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }
}
