package edu.vero.easyclass.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "online_class_test")
public class OnlineClassTest
{
    private int testId;

    private Date establishedTime;

    private Date deadline;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private List<Question> questions;

    private TeacherArrangement arrangement;

    @ManyToMany(targetEntity = Question.class)
    @JoinTable(name = "test_question", joinColumns = @JoinColumn(name = "testId"), inverseJoinColumns = @JoinColumn(name = "questionId"))
    public List<Question> getQuestions()
    {
        return questions;
    }

    public void setQuestions(List<Question> questions)
    {
        this.questions = questions;
    }

    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    public int getTestId()
    {
        return testId;
    }

    public void setTestId(int testId)
    {
        this.testId = testId;
    }

    @ManyToOne
    @JoinColumn(name = "arrangeId")
    public TeacherArrangement getArrangement()
    {
        return arrangement;
    }

    public void setArrangement(TeacherArrangement arrangement)
    {
        this.arrangement = arrangement;
    }

    public Date getEstablishedTime()
    {
        return establishedTime;
    }

    public void setEstablishedTime(Date establishedTime)
    {
        this.establishedTime = establishedTime;
    }

    public Date getDeadline()
    {
        return deadline;
    }

    public void setDeadline(Date deadline)
    {
        this.deadline = deadline;
    }
}
