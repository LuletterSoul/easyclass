package edu.vero.easyclass.domain;


import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "attendance")
public class Attendance
{

    private int attendanceId;

    private Date establishedTime;

    private Date deadline;

    private boolean isAttend;

    private boolean isClosed;

    private Date closedTime;

    private QRcode qRcode;

    @ApiModelProperty(hidden = true)
    private Set<SignRecord> signRecords;

    private TeacherArrangement arrangement;

    @ApiModelProperty(hidden = true)
    private Set<Vote> votes;

    @OneToMany(mappedBy = "attendance")
    public Set<Vote> getVotes()
    {
        return votes;
    }

    public void setVotes(Set<Vote> votes)
    {
        this.votes = votes;
    }

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

    @OneToMany(mappedBy = "attendance")
    public Set<SignRecord> getSignRecords()
    {
        return signRecords;
    }

    public void setSignRecords(Set<SignRecord> signRecords)
    {
        this.signRecords = signRecords;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codeId")
    public QRcode getqRcode()
    {
        return qRcode;
    }

    public void setqRcode(QRcode qRcode)
    {
        this.qRcode = qRcode;
    }

    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    public int getAttendanceId()
    {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId)
    {
        this.attendanceId = attendanceId;
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

    public boolean isAttend()
    {
        return isAttend;
    }

    public void setAttend(boolean attend)
    {
        isAttend = attend;
    }

    public boolean isClosed()
    {
        return isClosed;
    }

    public void setClosed(boolean closed)
    {
        isClosed = closed;
    }

    public Date getClosedTime()
    {
        return closedTime;
    }

    public void setClosedTime(Date closedTime)
    {
        this.closedTime = closedTime;
    }

}
