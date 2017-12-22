package edu.vero.easyclass.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "vote")
public class Vote
{
    private int voteId;

    private String voteContent;

    private Date establishedTime;

    private Date deadline;

    private boolean isClosed;

    @ApiModelProperty(hidden = true)
    private Set<VoteOption> options;

    private Attendance attendance;

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

    public boolean isClosed()
    {
        return isClosed;
    }

    public void setClosed(boolean closed)
    {
        isClosed = closed;
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

    @OneToMany(mappedBy = "vote")
    public Set<VoteOption> getOptions()
    {
        return options;
    }

    public void setOptions(Set<VoteOption> options)
    {
        this.options = options;
    }

    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    public int getVoteId()
    {
        return voteId;
    }

    public void setVoteId(int voteId)
    {
        this.voteId = voteId;
    }

    public String getVoteContent()
    {
        return voteContent;
    }

    public void setVoteContent(String voteContent)
    {
        this.voteContent = voteContent;
    }
}
