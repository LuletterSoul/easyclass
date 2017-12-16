package edu.vero.easyclass.domain;


import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "classtime")
public class ClassTime
{

    @GeneratedValue(generator = "timeId", strategy = GenerationType.IDENTITY)
    private int timeId;

    private String term;

    private String week;

    private String weekday;

    private String classOrder;

    private TeacherComment common;

    @OneToOne
    @JoinColumn(name = "commonId")
    public TeacherComment getCommon()
    {
        return common;
    }

    public void setCommon(TeacherComment common)
    {
        this.common = common;
    }

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

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this).add("timeId", timeId).add("term", term).add("week",
            week).add("weekday", weekday).add("classOrder", classOrder).add("common",
                common).toString();
    }
}
