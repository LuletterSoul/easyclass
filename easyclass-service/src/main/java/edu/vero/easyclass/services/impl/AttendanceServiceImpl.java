package edu.vero.easyclass.services.impl;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import edu.vero.easyclass.domain.*;
import edu.vero.easyclass.repositories.*;
import edu.vero.easyclass.services.AttendanceService;
import edu.vero.easyclass.services.ClassScheduleService;
import edu.vero.easyclass.services.StudentService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSException;

import javax.imageio.ImageIO;
import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 18:39 2017/12/16.
 * @since easyclass
 */

@Service
public class AttendanceServiceImpl implements AttendanceService
{
    private VoteJpaDao voteJpaDao;

    private AttendanceJpaDao attendanceJpaDao;

    private QRcodeJpaDao qRcodeJpaDao;

    private TeacherArrangementJpaDao arrangementJpaDao;

    private VoteOptionJpaDao voteOptionJpaDao;

    private SignRecordJpaDao signRecordJpaDao;

    private ClassScheduleJpaDao classScheduleJpaDao;

    private TestsJpaDao testsJpaDao;

    @Autowired
    public AttendanceServiceImpl(VoteJpaDao voteJpaDao, AttendanceJpaDao attendanceJpaDao,
                                 QRcodeJpaDao qRcodeJpaDao,
                                 TeacherArrangementJpaDao arrangementJpaDao,
                                 VoteOptionJpaDao voteOptionJpaDao,
                                 SignRecordJpaDao signRecordJpaDao,
                                 ClassScheduleJpaDao classScheduleJpaDao, TestsJpaDao testsJpaDao)
    {
        this.voteJpaDao = voteJpaDao;
        this.attendanceJpaDao = attendanceJpaDao;
        this.qRcodeJpaDao = qRcodeJpaDao;
        this.arrangementJpaDao = arrangementJpaDao;
        this.voteOptionJpaDao = voteOptionJpaDao;
        this.signRecordJpaDao = signRecordJpaDao;
        this.classScheduleJpaDao = classScheduleJpaDao;
        this.testsJpaDao = testsJpaDao;
    }

    @Override
    public Vote createVote(Integer attendanceId, Vote vote)
    {
        Attendance attendance = attendanceJpaDao.findOne(attendanceId);
        Date date = new Date();
        vote.setEstablishedTime(date);
        vote.setAttendance(attendance);
        voteJpaDao.save(vote);
        Set<VoteOption> voteOptions = vote.getOptions();
        for (VoteOption option : voteOptions)
        {
            option.setVote(vote);
        }
        voteOptionJpaDao.save(voteOptions);
        return vote;
    }

    @Override
    public QRcode deleteQRcode(Integer attendanceId)
    {
        Attendance attendance = attendanceJpaDao.findOne(attendanceId);
        QRcode qRcode = attendance.getqRcode();
        qRcodeJpaDao.delete(qRcode);
        return qRcode;
    }

    @Override
    public byte[] findQRcode(Integer attendanceId, Integer scheduleId, Integer height,
                             Integer width, String format, HttpServletRequest request)
    {
        String doAttendanceRealUrl = "/" + attendanceId + "/sign_records" + "?scheduleId="
                                     + scheduleId;
        ServletContext servletContext = request.getServletContext();
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new BitMatrix(2);// 生成矩阵
        try
        {
            bitMatrix = new MultiFormatWriter().encode(doAttendanceRealUrl, BarcodeFormat.QR_CODE,
                width, height, hints);
        }
        catch (WriterException e)
        {
            e.printStackTrace();
        }
        QRcode qRcode = new QRcode();
        String fileName = attendanceId + "_" + scheduleId +"_QRcode."+format;
        String relativePath = "\\attendances\\" + scheduleId + "\\QRcode\\" + fileName;
        String realPath = servletContext.getRealPath(relativePath);
        File QRfile = new File(realPath);
        qRcode.setFileName(fileName);
        qRcode.setFilePath(realPath);
        OutputStream fileStream = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 将矩阵转为Image
        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
        try
        {
            ImageIO.write(image, format, out);// 将BufferedImage转成out输出流
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        try {
            //将生成的二维码保存到本机
            FileUtils.writeByteArrayToFile(QRfile,out.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        qRcodeJpaDao.save(qRcode);
        return out.toByteArray();
    }

    // @Override
    // public QRcode findQRcode(Integer attendanceId)
    // {
    // Attendance attendance = attendanceJpaDao.findOne(attendanceId);
    // QRcode qRcode = attendance.getqRcode();
    // return qRcode;
    // }

    @Override
    public Attendance updateAttendance(Integer attendanceId)
    {
        Attendance attendance = attendanceJpaDao.findOne(attendanceId);
        attendance.setClosed(true);
        return attendanceJpaDao.save(attendance);
    }

    @Override
    public List<SignRecord> findSignRecords(Integer attendanceId)
    {
        Attendance attendance = attendanceJpaDao.findOne(attendanceId);
        Set<SignRecord> signRecordSet = attendance.getSignRecords();
        return new ArrayList<SignRecord>(signRecordSet);
    }

    @Override
    public Attendance createAttendance(Attendance attendance)
    {
        TeacherArrangement teacherArrangement = arrangementJpaDao.findOne(
            attendance.getArrangement().getArrangementId());
        QRcode qRcode = qRcodeJpaDao.findOne(attendance.getqRcode().getCodeId());
        attendance.setArrangement(teacherArrangement);
        attendance.setqRcode(qRcode);
        attendance.setEstablishedTime(new Date());
        return attendanceJpaDao.save(attendance);
    }

    @Override
    public Attendance deleteAttendance(Integer attendanceId)
    {
        Attendance attendance = attendanceJpaDao.findOne(attendanceId);
        attendanceJpaDao.delete(attendance);
        return attendance;
    }

    @Override
    public List<Vote> findVotes(Integer attendanceId)
    {
        return new ArrayList<>(attendanceJpaDao.findOne(attendanceId).getVotes());
    }

    @Override
    public SignRecord createSignRecord(Integer attendanceId, Integer scheduleId)
    {
        SignRecord signRecord = new SignRecord();
        ClassSchedule classSchedule = classScheduleJpaDao.findOne(scheduleId);
        Set<SignRecord> currentSignRecords = classSchedule.getSignRecords();
        Attendance attendance = attendanceJpaDao.findOne(attendanceId);
        //签到已关闭
        if (attendance.isClosed()) {
            throw new InvalidDataAccessApiUsageException("The attendance has been closed.");
        }
        // 判断是否已经签到;
        for (SignRecord record : currentSignRecords)
        {
            if (record.getAttendance().getAttendanceId() == attendanceId)
            {
                throw new DataIntegrityViolationException(
                    "you has already signed in this attendance.Please don't sign repeatedly.");
            }
        }
        signRecord.setSignTime(new Date());
        attendance.setAttendanceId(attendanceId);
        signRecord.setAttendance(attendance);
        signRecord.setSchedule(classSchedule);
        signRecordJpaDao.saveAndFlush(signRecord);
        return signRecord;
    }

    @Override
    public Vote findNewestVote(Integer attendanceId)
    {
        List<Vote> newestVote = voteJpaDao.findNewestVote(attendanceId);
        if (newestVote == null)
        {
            throw new EntityNotFoundException();
        }
        return voteJpaDao.findNewestVote(attendanceId).get(0);
    }

    @Override
    public List<Student> findAttendStudents(Integer attendanceId) {
        Attendance attendance = attendanceJpaDao.findOne(attendanceId);
        Set<SignRecord> signRecords = attendance.getSignRecords();
        List<Student> students = new ArrayList<>();
        for(SignRecord signRecord:signRecords){
            students.add(signRecord.getSchedule().getStudent());
        }
        return students;
    }

    @Override
    public List<Student> findAbsentStudents(Integer attendanceId) {
        List<Student> studentsAttend = findAttendStudents(attendanceId);
        TeacherArrangement arrangement = attendanceJpaDao.findOne(attendanceId).getArrangement();
        Set<ClassSchedule> schedules = arrangement.getSchedules();
        List<Student> students = new ArrayList<>();
        for(ClassSchedule schedule:schedules){
            students.add(schedule.getStudent());
        }
        students.removeAll(studentsAttend);
        return students;
    }
}
