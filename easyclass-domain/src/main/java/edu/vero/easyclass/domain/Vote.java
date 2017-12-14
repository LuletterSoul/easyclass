package edu.vero.easyclass.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="vote")
public class Vote {
    private int voteId;
    private String voteContent;
    private Set<VoteOption> options;
    private Attendance attendance;

    @ManyToOne
    @JoinColumn(name="attendanceId")
    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    @OneToMany(mappedBy = "vote")
    public Set<VoteOption> getOptions() {
        return options;
    }

    public void setOptions(Set<VoteOption> options) {
        this.options = options;
    }

    @Id
    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public String getVoteContent() {
        return voteContent;
    }

    public void setVoteContent(String voteContent) {
        this.voteContent = voteContent;
    }
}
