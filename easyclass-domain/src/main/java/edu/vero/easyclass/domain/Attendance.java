package edu.vero.easyclass.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "attendance")
public class Attendance {

    @GeneratedValue(generator = "attendanceId", strategy = GenerationType.IDENTITY)
    private int attendanceId;
    private Date establishTime;
    private Date deadline;
    private Date attendTime;
    private boolean isAttend;
    private boolean isClosed;
    private Date closedTime;
    private QRcode qRcode;
    private Set<SignRecord> signRecords;

    @OneToMany(mappedBy = "attendance")
    public Set<SignRecord> getSignRecords() {
        return signRecords;
    }

    public void setSignRecords(Set<SignRecord> signRecords) {
        this.signRecords = signRecords;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codeId")
    public QRcode getqRcode() {
        return qRcode;
    }

    public void setqRcode(QRcode qRcode) {
        this.qRcode = qRcode;
    }

    @Id
    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Date getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(Date establishTime) {
        this.establishTime = establishTime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getAttendTime() {
        return attendTime;
    }

    public void setAttendTime(Date attendTime) {
        this.attendTime = attendTime;
    }

    public boolean isAttend() {
        return isAttend;
    }

    public void setAttend(boolean attend) {
        isAttend = attend;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public Date getClosedTime() {
        return closedTime;
    }

    public void setClosedTime(Date closedTime) {
        this.closedTime = closedTime;
    }
}
