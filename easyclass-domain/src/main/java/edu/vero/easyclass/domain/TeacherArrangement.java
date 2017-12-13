package edu.vero.easyclass.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teacher_arrangement")
public class TeacherArrangement {

    @GeneratedValue(generator = "arrangeId", strategy = GenerationType.IDENTITY)
    private int arrangeId;
    private String place;
    private Teacher teacher;
    private Course course;
    private List<OnlineClassTest> tests;
    private List<ClassTime> classTimes;
    private Set<Courseware> coursewares;
    private Set<Notice> notices;
    private TeacherComment comment;

    @OneToMany(mappedBy = "arrangement")
    public Set<Notice> getNotices() {
        return notices;
    }

    public void setNotices(Set<Notice> notices) {
        this.notices = notices;
    }

    @OneToOne(mappedBy = "arrangement")
    @JoinColumn(name = "commentId")
    public TeacherComment getComment() {
        return comment;
    }

    public void setComment(TeacherComment comment) {
        this.comment = comment;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "arrangeId")
    public Set<Courseware> getCoursewares() {
        return coursewares;
    }

    public void setCoursewares(Set<Courseware> coursewares) {
        this.coursewares = coursewares;
    }

    @OneToMany(mappedBy = "arrangement")
    public List<OnlineClassTest> getTests() {
        return tests;
    }

    public void setTests(List<OnlineClassTest> tests) {
        this.tests = tests;
    }

    @OneToMany
    @JoinColumn(name = "arrangeId")
    public List<ClassTime> getClassTimes() {
        return classTimes;
    }

    public void setClassTimes(List<ClassTime> classTimes) {
        this.classTimes = classTimes;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseId")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Id
    public int getArrangeId() {
        return arrangeId;
    }

    public void setArrangeId(int arrangeId) {
        this.arrangeId = arrangeId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "teacherId")
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
