package edu.vero.easyclass.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.RowId;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {
    @GeneratedValue(generator = "questionId", strategy = GenerationType.IDENTITY)
    private int questionId;
    private int answerOrder;
    private Set<QuestionOption> options;
    private Course course;
    private Set<OnlineClassTest> tests;

    @ManyToMany(mappedBy = "questions")
    public Set<OnlineClassTest> getTests() {
        return tests;
    }

    public void setTests(Set<OnlineClassTest> tests) {
        this.tests = tests;
    }

    @ManyToOne
    @JoinColumn(name="courseId")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Id
    @GenericGenerator(name = "identityGenerator",strategy = "identity")
    @GeneratedValue(generator = "identityGenerator")
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswerOrder() {
        return answerOrder;
    }

    public void setAnswerOrder(int answerOrder) {
        this.answerOrder = answerOrder;
    }

    @OneToMany(mappedBy = "question")
    public Set<QuestionOption> getOptions() {
        return options;
    }

    public void setOptions(Set<QuestionOption> options) {
        this.options = options;
    }
}
