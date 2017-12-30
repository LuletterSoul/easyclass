package edu.vero.easyclass.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "homework_record")
public class HomeworkRecord {
    private int homeworkrecordId;
    private String title;

    private String content;
    private Date establishedTime;

    private Date deadline;
    private TeacherArrangement arrangement;

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

    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    public int getHomeworkRecordId()
    {
        return homeworkrecordId;
    }

    public void setHomeworkRecordId(int homeworkrecordId)
    {
        this.homeworkrecordId = homeworkrecordId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
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
