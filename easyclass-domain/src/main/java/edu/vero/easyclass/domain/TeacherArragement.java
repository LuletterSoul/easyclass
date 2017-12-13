package edu.vero.easyclass.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="teacher_arragement")
public class TeacherArragement {

    @GeneratedValue(generator = "arrageId",strategy = GenerationType.IDENTITY)
    private int arrageId;
    private String place;
    private Teacher teacher;
    private Course course;
    private List<OnlineClassTest> tests;
    private List<ClassTime> classTimes;
    private Set<Courseware> coursewares;
    private TeacherCommon common;

    @OneToOne
    @JoinColumn(name="commonId")
    public TeacherCommon getCommon() {
        return common;
    }

    public void setCommon(TeacherCommon common) {
        this.common = common;
    }

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="arrageId")
    public Set<Courseware> getCoursewares() {
        return coursewares;
    }

    public void setCoursewares(Set<Courseware> coursewares) {
        this.coursewares = coursewares;
    }

    @OneToMany(mappedBy = "arragement")
    public List<OnlineClassTest> getTests() {
        return tests;
    }

    public void setTests(List<OnlineClassTest> tests) {
        this.tests = tests;
    }

    @OneToMany
    @JoinColumn(name="arrageId")
    public List<ClassTime> getClassTimes() {
        return classTimes;
    }

    public void setClassTimes(List<ClassTime> classTimes) {
        this.classTimes = classTimes;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="courseId")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Id
    public int getArrageId() {
        return arrageId;
    }

    public void setArrageId(int arrageId) {
        this.arrageId = arrageId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }



    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="teacherId")
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
