package edu.vero.easyclass.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "class_time")
public class ClassTime
{

    @GeneratedValue(generator = "timeId", strategy = GenerationType.IDENTITY)
    private int timeId;

    private String term;

    private String week;

    private String weekday;

    private String classOrder;

    private List<ClassTimeComment> classTimeComments;

    @Id
    @GenericGenerator(name = "identityGenerator", strategy = "identity")
    @GeneratedValue(generator = "identityGenerator")
    public int getTimeId()
    {
        return timeId;
    }

    public void setTimeId(int timeId)
    {
        this.timeId = timeId;
    }

    public String getTerm()
    {
        return term;
    }

    public void setTerm(String term)
    {
        this.term = term;
    }

    public String getWeek()
    {
        return week;
    }

    public void setWeek(String week)
    {
        this.week = week;
    }

    public String getWeekday()
    {
        return weekday;
    }

    public void setWeekday(String weekday)
    {
        this.weekday = weekday;
    }

    public String getClassOrder()
    {
        return classOrder;
    }

    public void setClassOrder(String classOrder)
    {
        this.classOrder = classOrder;
    }

    /**
     * TeachingComment 里面没有双向关联关系，需要加入中间表
     * @return
     */
    @OneToMany(mappedBy = "classTime")
    @JoinTable(name = "time_comments"
            ,joinColumns = @JoinColumn(name = "timeId",referencedColumnName = "timeId")
            ,inverseJoinColumns = @JoinColumn(name = "commentId",referencedColumnName = "commentId"))
    public List<ClassTimeComment> getClassTimeComments() {
        return classTimeComments;
    }

    public void setClassTimeComments(List<ClassTimeComment> classTimeComments) {
        this.classTimeComments = classTimeComments;
}
}
