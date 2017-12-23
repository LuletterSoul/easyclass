package edu.vero.easyclass.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "homework")
public class Homework
{

    private int homeworkId;

    private String title;

    private String content;

    private String fileName;

    private String filePath;

    private Date establishedTime;

    private Date deadline;

    private int size;

    private boolean isSubmitted;

    private ClassSchedule schedule;

    @ManyToOne
    @JoinColumn(name="scheduleId")
    public ClassSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(ClassSchedule schedule) {
        this.schedule = schedule;
    }

    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    public int getHomeworkId()
    {
        return homeworkId;
    }

    public void setHomeworkId(int homeworkId)
    {
        this.homeworkId = homeworkId;
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

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFilePath()
    {
        return filePath;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
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

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public boolean isSubmitted()
    {
        return isSubmitted;
    }

    public void setSubmitted(boolean submitted)
    {
        isSubmitted = submitted;
    }
}
