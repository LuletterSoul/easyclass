package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.*;
import edu.vero.easyclass.repositories.*;
import edu.vero.easyclass.services.TeacherArrangementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 0:12 2017/12/15.
 * @since easyclass
 */

@Service
public class TeacherArrangementServiceImpl implements TeacherArrangementService
{

    private TeacherArrangementJpaDao teacherArrangementJpaDao;

    private NoticeJpaDao noticeJpaDao;

    private CoursewareJpaDao coursewareJpaDao;

    private OnlineClassTestJpaDao onlineClassTestJpaDao;

    private AttendanceJpaDao attendanceJpaDao;

    private TestRecordJpaDao testRecordJpaDao;

    @Autowired
    public void setTestRecordJpaDao(TestRecordJpaDao testRecordJpaDao)
    {
        this.testRecordJpaDao = testRecordJpaDao;
    }

    @Autowired
    public void setAttendanceJpaDao(AttendanceJpaDao attendanceJpaDao)
    {
        this.attendanceJpaDao = attendanceJpaDao;
    }

    @Autowired
    public void setOnlineClassTestJpaDao(OnlineClassTestJpaDao onlineClassTestJpaDao)
    {
        this.onlineClassTestJpaDao = onlineClassTestJpaDao;
    }

    @Autowired
    public void setCoursewareJpaDao(CoursewareJpaDao coursewareJpaDao)
    {
        this.coursewareJpaDao = coursewareJpaDao;
    }

    @Autowired
    public void setNoticeJpaDao(NoticeJpaDao noticeJpaDao)
    {
        this.noticeJpaDao = noticeJpaDao;
    }

    @Autowired
    public void setTeacherArrangementJpaDao(TeacherArrangementJpaDao teacherArrangementJpaDao)
    {
        this.teacherArrangementJpaDao = teacherArrangementJpaDao;
    }

    @Override
    public Notice createNotice(Integer arrangementId, Notice notice)
    {
        // 先从数据库里面查找出对应教师安排表
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);
        // 给公告关联对应的教师安排表
        notice.setArrangement(teacherArrangement);
        // 这步可以删去，因为教师安排表中没有对应的公告键
        // teacherArrangement.getNotices().add(notice);
        // 持久化公告
        noticeJpaDao.saveAndFlush(notice);
        teacherArrangementJpaDao.saveAndFlush(teacherArrangement);
        return notice;
    }

    @Override
    public OnlineClassTest createOnlineClassTest(Integer arrangementId,
                                                 OnlineClassTest onlineClassTest)
    {

        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);

        onlineClassTest.setArrangement(teacherArrangement);

        onlineClassTestJpaDao.saveAndFlush(onlineClassTest);
        teacherArrangementJpaDao.saveAndFlush(teacherArrangement);
        return onlineClassTest;
    }

    @Override
    public Notice findNewestNotices(Integer arrangementId)
    {
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);
        Set<Notice> notices0 = teacherArrangement.getNotices();
        List<Notice> notices1 = new ArrayList<Notice>(notices0);
        Collections.sort(notices1, new Comparator<Notice>()
        {
            @Override
            public int compare(Notice o1, Notice o2)
            {

                return o1.getEstablishedTime().toString().compareTo(
                    o2.getEstablishedTime().toString());
            }

        });
        Set<Notice> notices = new LinkedHashSet<Notice>(notices1);// 这里注意使用LinkedHashSet
        Iterator<Notice> it = notices.iterator();
        return it.next();

    }

    @Override
    public Attendance createAttendance(Integer arrangementId, Attendance attendance)
    {
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);

        attendance.setArrangement(teacherArrangement);

        attendanceJpaDao.saveAndFlush(attendance);
        teacherArrangementJpaDao.saveAndFlush(teacherArrangement);
        return attendance;
    }

    @Override
    public TeacherArrangement findArrangement(Integer arrangementId)
    {
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);
        return teacherArrangement;
    }

    @Override
    public List<OnlineClassTest> findAllOnlineClassTest(Integer arrangementId)
    {
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);
        List<OnlineClassTest> onlineClassTest = teacherArrangement.getTests();
        return onlineClassTest;
    }

    @Override
    public List<ClassTime> findAllClassTime(Integer arrangementId)
    {
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);

        List<ClassTime> classTime = teacherArrangement.getClassTimes();
        return classTime;
    }

    @Override
    public TeacherComment findTeacherComment(Integer arrangementId)
    {
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);
        TeacherComment teacherComment = teacherArrangement.getComment();
        return teacherComment;

    }

    @Override
    public Course findCourse(Integer arrangementId)
    {
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);
        Course course = teacherArrangement.getCourse();
        return course;
    }

    @Override
    public List<Notice> findAllNotice(Integer arrangementId)
    {
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);

        Set<Notice> notices0 = teacherArrangement.getNotices();
        List<Notice> notices1 = new ArrayList<Notice>(notices0);
        return notices1;
    }

    @Override
    public Teacher findTeacher(Integer arrangementId)
    {
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);
        Teacher teacher = teacherArrangement.getTeacher();
        return teacher;
    }

    @Override
    public List<TeacherArrangement> findAllArrangements()
    {
        List<TeacherArrangement> list = teacherArrangementJpaDao.findAll();
        return list;
    }

    @Override
    public List<Courseware> findAllCoursewares(Integer arrangementId)
    {
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);
        Set<Courseware> courseware0 = teacherArrangement.getCoursewares();
        List<Courseware> courseware1 = new ArrayList<Courseware>(courseware0);
        return courseware1;
    }
}
