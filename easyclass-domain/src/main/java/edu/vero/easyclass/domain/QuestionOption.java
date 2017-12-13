package edu.vero.easyclass.domain;

import javax.persistence.*;

@Entity
@Table(name = "question_option")      //option冲突
public class QuestionOption {

    @GeneratedValue(generator = "optionId", strategy = GenerationType.IDENTITY)
    private int optionId;
    private String optionOrder;
    private String content;
    private Question question;

    @ManyToOne
    @JoinColumn(name = "questionId")
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Id
    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public String getOptionOrder() {
        return optionOrder;
    }

    public void setOptionOrder(String optionOrder) {
        this.optionOrder = optionOrder;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
