package edu.vero.easyclass.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {
    @GeneratedValue(generator = "questionId", strategy = GenerationType.IDENTITY)
    private int questionId;
    private int answerOrder;
    private Set<QuestionOption> options;
    private OnlineClassTest classTest;

    @ManyToOne
    @JoinColumn(name = "testId")
    public OnlineClassTest getClassTest() {
        return classTest;
    }

    public void setClassTest(OnlineClassTest classTest) {
        this.classTest = classTest;
    }

    @Id
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
