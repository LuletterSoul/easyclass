package edu.vero.easyclass.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="teacher")
@PrimaryKeyJoinColumn(name="userId")
public class Teacher extends User{
    private String teacherId;
    private String teacherName;
    private String teacherGender;
    private Set<TeacherArragement> arragementSet;

    @OneToMany(mappedBy = "teacher")
    public Set<TeacherArragement> getArragementSet() {
        return arragementSet;
    }

    public void setArragementSet(Set<TeacherArragement> arragementSet) {
        this.arragementSet = arragementSet;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(String teacherGender) {
        this.teacherGender = teacherGender;
    }
}
