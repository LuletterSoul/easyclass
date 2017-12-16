package edu.vero.easyclass.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "teacher_arrangement")
public class TeacherArrangement
{

    @GeneratedValue(generator = "arrangeId", strategy = GenerationType.IDENTITY)
    private int arrangeId;

    private String place;

    private Teacher teacher;

    private Course course;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<OnlineClassTest> tests;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<ClassTime> classTimes;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Set<Courseware> coursewares;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Set<Notice> notices;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private TeacherComment comment;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Set<Attendance> attendances;

    @OneToMany(mappedBy = "arrangement")
    public Set<Attendance> getAttendances()
    {
        return attendances;
    }

    public void setAttendances(Set<Attendance> attendances)
    {
        this.attendances = attendances;
    }

    @OneToMany(mappedBy = "arrangement")
    public Set<Notice> getNotices()
    {
        return notices;
    }

    public void setNotices(Set<Notice> notices)
    {
        this.notices = notices;
    }

    @OneToOne
    @JoinColumn(name = "commentId")
    public TeacherComment getComment()
    {
        return comment;
    }

    public void setComment(TeacherComment comment)
    {
        this.comment = comment;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "arrangeId")
    public Set<Courseware> getCoursewares()
    {
        return coursewares;
    }

    public void setCoursewares(Set<Courseware> coursewares)
    {
        this.coursewares = coursewares;
    }

    @OneToMany(mappedBy = "arrangement")
    public List<OnlineClassTest> getTests()
    {
        return tests;
    }

    public void setTests(List<OnlineClassTest> tests)
    {
        this.tests = tests;
    }

    @OneToMany
    @JoinColumn(name = "arrangeId")
    public List<ClassTime> getClassTimes()
    {
        return classTimes;
    }

    public void setClassTimes(List<ClassTime> classTimes)
    {
        this.classTimes = classTimes;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseId")
    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }

    @Id
    @GenericGenerator(name = "identityGenerator", strategy = "identity")
    @GeneratedValue(generator = "identityGenerator")
    public int getArrangeId()
    {
        return arrangeId;
    }

    public void setArrangeId(int arrangeId)
    {
        this.arrangeId = arrangeId;
    }

    public String getPlace()
    {
        return place;
    }

    public void setPlace(String place)
    {
        this.place = place;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "teacherId")
    public Teacher getTeacher()
    {
        return teacher;
    }

    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }
}
