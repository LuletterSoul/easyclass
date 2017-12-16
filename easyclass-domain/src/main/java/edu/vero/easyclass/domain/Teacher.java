package edu.vero.easyclass.domain;


import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "Teacher")
public class Teacher extends User {
    private String teacherId;
    private String teacherName;
    private String teacherGender;
    private Set<TeacherArrangement> arrangementSet;

    @OneToMany(mappedBy = "teacher")
    public Set<TeacherArrangement> getArragementSet() {
        return arrangementSet;
    }

    public void setArragementSet(Set<TeacherArrangement> arragementSet) {
        this.arrangementSet = arragementSet;
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
