package edu.vero.easyclass.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "online_class_test")
public class OnlineClassTest {
    @GeneratedValue(generator = "testId", strategy = GenerationType.IDENTITY)
    private int testId;
    private Date establishTime;
    private Date deadline;
    private List<Question> questions;
    private TeacherArrangement arrangement;

    @ManyToMany(targetEntity = Question.class)
    @JoinTable(name="test_question",
            joinColumns = @JoinColumn(name="testId"),
            inverseJoinColumns = @JoinColumn(name="questionId"))
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Id
    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    @ManyToOne
    @JoinColumn(name = "arrangeId")
    public TeacherArrangement getArrangement() {
        return arrangement;
    }

    public void setArrangement(TeacherArrangement arrangement) {
        this.arrangement = arrangement;
    }


    public Date getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(Date establishTime) {
        this.establishTime = establishTime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
