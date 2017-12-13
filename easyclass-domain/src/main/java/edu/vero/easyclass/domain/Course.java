package edu.vero.easyclass.domain;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="course")
public class Course {

    @GeneratedValue(generator = "courseId",strategy = GenerationType.IDENTITY)
    private int courseId;
    private String courseName;
    private double credit;
    private String type;

    @Id
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
