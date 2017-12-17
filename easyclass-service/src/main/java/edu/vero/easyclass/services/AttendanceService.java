package edu.vero.easyclass.services;

import edu.vero.easyclass.domain.Attendance;
import edu.vero.easyclass.domain.QRcode;
import edu.vero.easyclass.domain.Vote;

import java.util.List;

public interface AttendanceService {
    public Vote createVote(Integer attendanceId);
    public QRcode deleteQRcode(Integer attendanceId);
    public QRcode findQRcode(Integer attendanceId);
    public Attendance updateAttendance(Attendance attendance);
    public Attendance findSignRecords(Integer attendanceId);
}
