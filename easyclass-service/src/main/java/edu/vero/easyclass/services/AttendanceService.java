package edu.vero.easyclass.services;


import edu.vero.easyclass.domain.*;
import io.swagger.models.auth.In;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;


public interface AttendanceService
{
    Vote createVote(Integer attendanceId, Vote vote);

    QRcode deleteQRcode(Integer attendanceId);

    byte[] findQRcode(Integer attendanceId, Integer scheduleId, Integer height, Integer width,
                      String format, HttpServletRequest request);

    Attendance updateAttendance(Integer attendanceId);

    List<SignRecord> findSignRecords(Integer attendanceId);

    Attendance createAttendance(Attendance attendance);

    Attendance deleteAttendance(Integer attendanceId);

    List<Vote> findVotes(Integer attendanceId);

    SignRecord createSignRecord(Integer attendanceId, Integer scheduleId);

    Vote findNewestVote(Integer attendanceId);

    List<Student> findAttendStudents(Integer attendanceId);

    List<Student> findAbsentStudents(Integer attendanceId);
}
