package edu.vero.easyclass.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 12:32 2017/12/19.
 * @since easyclass
 */
@Entity
@DiscriminatorValue(value = "Course")
public class CourseComment extends TeachingComment
{
    private TeacherArrangement arrangement;

    private ClassSchedule schedule;

    public void setArrangement(TeacherArrangement arrangement)
    {
        this.arrangement = arrangement;
    }

    @ManyToOne
    @JoinColumn(name = "arrangementId")
    public TeacherArrangement getArrangement()
    {
        return arrangement;
    }

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "scheduleId")
    public ClassSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(ClassSchedule schedule) {
        this.schedule = schedule;
    }
}
