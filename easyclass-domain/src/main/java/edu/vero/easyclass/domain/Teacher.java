package edu.vero.easyclass.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "teacher")
@PrimaryKeyJoinColumn(name = "userId")
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
