package edu.vero.easyclass.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "test_record")
public class TestRecord
{
    private int recordId;

    private float score;

    private String answer;

    private OnlineClassTest test;

    private ClassSchedule schedule;

    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    public int getRecordId()
    {
        return recordId;
    }

    public void setRecordId(int recordId)
    {
        this.recordId = recordId;
    }

    @ManyToOne
    @JoinColumn(name = "scheduleId")
    public ClassSchedule getSchedule()
    {
        return schedule;
    }

    public void setSchedule(ClassSchedule schedule)
    {
        this.schedule = schedule;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "testId")
    public OnlineClassTest getTest()
    {
        return test;
    }

    public void setTest(OnlineClassTest test)
    {
        this.test = test;
    }

    public float getScore()
    {
        return score;
    }

    public void setScore(float score)
    {
        this.score = score;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }
}
