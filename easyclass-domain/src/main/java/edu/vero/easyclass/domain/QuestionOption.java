package edu.vero.easyclass.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "question_option") // option冲突
public class QuestionOption
{

    private int optionId;

    private Integer optionOrder;

    private String content;

    @JsonIgnore
    private Question question;

    @ManyToOne
    @JoinColumn(name = "questionId")
    public Question getQuestion()
    {
        return question;
    }

    public void setQuestion(Question question)
    {
        this.question = question;
    }

    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    public int getOptionId()
    {
        return optionId;
    }

    public void setOptionId(int optionId)
    {
        this.optionId = optionId;
    }

    public Integer getOptionOrder()
    {
        return optionOrder;
    }

    public void setOptionOrder(Integer optionOrder)
    {
        this.optionOrder = optionOrder;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }
}
