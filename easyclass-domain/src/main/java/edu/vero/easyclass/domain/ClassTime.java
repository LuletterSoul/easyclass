package edu.vero.easyclass.domain;


import javax.persistence.*;

@Entity
@Table(name="classtime")
public class ClassTime {

    @GeneratedValue(generator = "timeId",strategy = GenerationType.IDENTITY)
    private int timeId;
    private String term;
    private String week;
    private String weekday;
    private String classOrder;
    private TeacherCommon common;

    @OneToOne
    @JoinColumn(name="commonId")
    public TeacherCommon getCommon() {
        return common;
    }

    public void setCommon(TeacherCommon common) {
        this.common = common;
    }

    @Id
    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getClassOrder() {
        return classOrder;
    }

    public void setClassOrder(String classOrder) {
        this.classOrder = classOrder;
    }
}
