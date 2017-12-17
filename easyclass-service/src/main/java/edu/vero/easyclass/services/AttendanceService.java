package edu.vero.easyclass.services;

import edu.vero.easyclass.domain.Attendance;
import edu.vero.easyclass.domain.QRcode;
import edu.vero.easyclass.domain.Vote;

import java.util.List;

public interface AttendanceService {
    public Vote createVote(String attendanceId);
    public QRcode deleteQRcode(String attendanceId);
    public QRcode findQRcode(String attendanceId);
    public Attendance updateAttendance(String attendanceId);
    public Attendance findSignRecords(String attendanceId);
}
