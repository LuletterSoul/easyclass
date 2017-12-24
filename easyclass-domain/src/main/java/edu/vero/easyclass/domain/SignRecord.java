package edu.vero.easyclass.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "sign_record")
public class SignRecord
{
    private int signId;

    private Date signTime;

    private ClassSchedule schedule;

    private Attendance attendance;

    public Date getSignTime()
    {
        return signTime;
    }

    public void setSignTime(Date signTime)
    {
        this.signTime = signTime;
    }


    @ManyToOne
    @JoinColumn(name = "attendanceId")
    public Attendance getAttendance()
    {
        return attendance;
    }

    public void setAttendance(Attendance attendance)
    {
        this.attendance = attendance;
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

    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    public int getSignId()
    {
        return signId;
    }

    public void setSignId(int signId)
    {
        this.signId = signId;
    }

}
