package edu.vero.easyclass.domain;

import javax.persistence.*;

@Entity
@Table(name="sign_record")
public class SignRecord {
    @GeneratedValue(generator = "signId",strategy = GenerationType.IDENTITY)
    private int signId;
    private boolean isSign;
    private ClassSchedule schedule;
    private Attendance attendance;

    @ManyToOne
    @JoinColumn(name="attendanceId")
    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    @ManyToOne
    @JoinColumn(name="scheduleId")
    public ClassSchedule getSchedule() {

        return schedule;
    }

    public void setSchedule(ClassSchedule schedule) {
        this.schedule = schedule;
    }

    @Id
    public int getSignId() {
        return signId;
    }

    public void setSignId(int signId) {
        this.signId = signId;
    }

    public boolean isSign() {
        return isSign;
    }

    public void setSign(boolean sign) {
        isSign = sign;
    }
}
