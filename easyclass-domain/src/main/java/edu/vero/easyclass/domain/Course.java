package edu.vero.easyclass.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "course")
public class Course
{

    private int courseId;

    private String courseName;

    private double credit;

    private String type;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Set<Question> questions;

    @OneToMany(mappedBy = "course")
    public Set<Question> getQuestions()
    {
        return questions;
    }

    public void setQuestions(Set<Question> questions)
    {
        this.questions = questions;
    }

    @Id
    @GenericGenerator(name = "identityGenerator", strategy = "identity")
    @GeneratedValue(generator = "identityGenerator")
    public int getCourseId()
    {
        return courseId;
    }

    public void setCourseId(int courseId)
    {
        this.courseId = courseId;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public double getCredit()
    {
        return credit;
    }

    public void setCredit(double credit)
    {
        this.credit = credit;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this).add("courseId", courseId).add("courseName",
            courseName).add("credit", credit).add("type", type).toString();
    }
}
