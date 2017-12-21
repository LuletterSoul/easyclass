package edu.vero.easyclass.services;


import edu.vero.easyclass.domain.Attendance;
import edu.vero.easyclass.domain.QRcode;
import edu.vero.easyclass.domain.SignRecord;
import edu.vero.easyclass.domain.Vote;

import java.util.List;
import java.util.Set;


public interface AttendanceService
{
    Vote createVote(Integer attendanceId, Vote vote);

    QRcode deleteQRcode(Integer attendanceId);

    QRcode findQRcode(Integer attendanceId);

    Attendance updateAttendance(Attendance attendance);

    List<SignRecord> findSignRecords(Integer attendanceId);

    Attendance createAttendance(Attendance attendance,Integer arrangeId);

    Attendance deleteAttendance(Integer attendanceId);
}
