package edu.vero.easyclass.domain;


import com.google.common.base.Objects;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.Set;


@ApiModel(value = "Teacher", description = "教师实体")
@Entity
@DiscriminatorValue(value = "Teacher")
public class Teacher extends User
{
    private String teacherId;

    private String teacherName;

    private String teacherGender;

    private Set<TeacherArrangement> arrangementSet;

    @OneToMany(mappedBy = "teacher")
    public Set<TeacherArrangement> getArragementSet()
    {
        return arrangementSet;
    }

    public void setArragementSet(Set<TeacherArrangement> arrangementSet)
    {
        this.arrangementSet = arrangementSet;
    }

    public String getTeacherId()
    {
        return teacherId;
    }

    public void setTeacherId(String teacherId)
    {
        this.teacherId = teacherId;
    }

    public String getTeacherName()
    {
        return teacherName;
    }

    public void setTeacherName(String teacherName)
    {
        this.teacherName = teacherName;
    }

    public String getTeacherGender()
    {
        return teacherGender;
    }

    public void setTeacherGender(String teacherGender)
    {
        this.teacherGender = teacherGender;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher that = (Teacher)o;
        return Objects.equal(this.teacherId, that.teacherId)
               && Objects.equal(this.teacherName, that.teacherName)
               && Objects.equal(this.teacherGender, that.teacherGender);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(teacherId, teacherName, teacherGender, arrangementSet);
    }
}
