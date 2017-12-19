package edu.vero.easyclass.domain;


import javax.persistence.*;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 12:33 2017/12/19.
 * @since easyclass
 */

@Entity
@DiscriminatorValue(value = "Per")
public class ClassTimeComment extends TeachingComment
{

    private ClassSchedule schedule;
    private ClassTime classTime;

    @ManyToOne
    @JoinColumn(name = "timeId")
    public ClassTime getClassTime()
    {
        return classTime;
    }

    public void setClassTime(ClassTime classTime)
    {
        this.classTime = classTime;
    }

    public ClassSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(ClassSchedule schedule) {
        this.schedule = schedule;
    }
}
