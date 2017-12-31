package edu.vero.easyclass.domain;


import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "teacher_arrangement")
public class TeacherArrangement {

    private int arrangementId;

    private String place;

    private Teacher teacher;

    private Course course;

    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    public int getArrangementId() {
        return arrangementId;
    }


    public void setArrangementId(int arrangementId) {
        this.arrangementId = arrangementId;
    }

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Set<ClassSchedule> schedules;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Set<OnlineClassTest> tests;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Set<ClassTime> classTimes;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Set<Courseware> coursewares;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Set<Notice> notices;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Set<CourseComment> courseComments;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Set<Attendance> attendances;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Set<Homework> homeworks;

//    @JsonIgnore
//    @ApiModelProperty(hidden = true)
//    private Set<Homework> homeworks;


    @JsonIgnore
    @OneToMany(mappedBy = "arrangement")
    public Set<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(Set<Attendance> attendances) {
        this.attendances = attendances;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "arrangement")
    public Set<Notice> getNotices() {
        return notices;
    }

    public void setNotices(Set<Notice> notices) {
        this.notices = notices;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "arrangement")
    public Set<Courseware> getCoursewares() {
        return coursewares;
    }

    public void setCoursewares(Set<Courseware> coursewares) {
        this.coursewares = coursewares;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "arrangement")
    public Set<OnlineClassTest> getTests() {
        return tests;
    }

    public void setTests(Set<OnlineClassTest> tests) {
        this.tests = tests;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "arrangement")
    public Set<ClassTime> getClassTimes() {
        return classTimes;
    }

    public void setClassTimes(Set<ClassTime> classTimes) {
        this.classTimes = classTimes;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "courseId")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @OneToMany(mappedBy = "arrangement")
    public Set<CourseComment> getCourseComments() {
        return courseComments;
    }

    public void setCourseComments(Set<CourseComment> courseComments) {
        this.courseComments = courseComments;
    }


//    @OneToMany(mappedBy = "arrangement")
//    public Set<Homework> getHomeworks() {
//        return homeworks;
//    }
//
//    public void setHomeworks(Set<Homework> homeworks) {
//        this.homeworks = homeworks;
//    }

    @OneToMany(mappedBy = "teacherArrangement")
    public Set<ClassSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<ClassSchedule> schedules) {
        this.schedules = schedules;
    }

    @OneToMany(mappedBy = "arrangement")
    public Set<Homework> getHomeworks() {
        return homeworks;
    }

    public void setHomeworks(Set<Homework> homeworks) {
        this.homeworks = homeworks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherArrangement that = (TeacherArrangement) o;
        return arrangementId == that.arrangementId;
    }
}
