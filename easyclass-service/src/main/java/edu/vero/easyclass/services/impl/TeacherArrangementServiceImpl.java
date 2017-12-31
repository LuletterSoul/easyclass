package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.domain.*;
import edu.vero.easyclass.repositories.*;
import edu.vero.easyclass.services.TeacherArrangementService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 0:12 2017/12/15.
 * @since easyclass
 */

@Service
public class TeacherArrangementServiceImpl implements TeacherArrangementService {

    private TeacherArrangementJpaDao teacherArrangementJpaDao;

    private NoticeJpaDao noticeJpaDao;

    private CoursewareJpaDao coursewareJpaDao;

    private OnlineClassTestJpaDao onlineClassTestJpaDao;

    private AttendanceJpaDao attendanceJpaDao;

    private TestRecordJpaDao testRecordJpaDao;

    private CourseCommentJpaDao courseCommentJpaDao;

    private TeacherJpaDao teacherJpaDao;

    private CourseJpaDao courseJpaDao;

    private QuestionJpaDao questionJpaDao;

    private TestsJpaDao testsJpaDao;

    private HomeworkJpaDao homeworkJpaDao;

    private ClassScheduleJpaDao classScheduleJpaDao;

    private HomeworkRecordJpaDao homeworkRecordJpaDao;

    @Autowired
    public TeacherArrangementServiceImpl(TeacherArrangementJpaDao teacherArrangementJpaDao,
                                         NoticeJpaDao noticeJpaDao,
                                         CoursewareJpaDao coursewareJpaDao,
                                         OnlineClassTestJpaDao onlineClassTestJpaDao,
                                         AttendanceJpaDao attendanceJpaDao,
                                         TestRecordJpaDao testRecordJpaDao,
                                         CourseCommentJpaDao courseCommentJpaDao,
                                         TeacherJpaDao teacherJpaDao, CourseJpaDao courseJpaDao,
                                         QuestionJpaDao questionJpaDao,
                                         HomeworkJpaDao homeworkJpaDao,
                                         ClassScheduleJpaDao classScheduleJpaDao,
                                         HomeworkRecordJpaDao homeworkRecordJpaDao) {
        this.teacherArrangementJpaDao = teacherArrangementJpaDao;
        this.noticeJpaDao = noticeJpaDao;
        this.coursewareJpaDao = coursewareJpaDao;
        this.onlineClassTestJpaDao = onlineClassTestJpaDao;
        this.attendanceJpaDao = attendanceJpaDao;
        this.testRecordJpaDao = testRecordJpaDao;
        this.courseCommentJpaDao = courseCommentJpaDao;
        this.teacherJpaDao = teacherJpaDao;
        this.courseJpaDao = courseJpaDao;
        this.questionJpaDao = questionJpaDao;
        this.homeworkJpaDao = homeworkJpaDao;
        this.classScheduleJpaDao = classScheduleJpaDao;
        this.homeworkRecordJpaDao = homeworkRecordJpaDao;
    }

    @Override
    public Notice createNotice(Integer arrangementId, Notice notice) {
        // 先从数据库里面查找出对应教师安排表
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);
        // 给公告关联对应的教师安排表
        notice.setArrangement(teacherArrangement);
        // 这步可以删去，因为教师安排表中没有对应的公告键
        // teacherArrangement.getNotices().add(notice);
        // 持久化公告
        notice.setEstablishedTime(new Date());
        noticeJpaDao.saveAndFlush(notice);
        teacherArrangementJpaDao.saveAndFlush(teacherArrangement);
        return notice;
    }

    @Override
    public OnlineClassTest createOnlineClassTest(Integer arrangementId,
                                                 OnlineClassTest onlineClassTest) {

        TeacherArrangement teacherArrangement = findArrangement(arrangementId);
        List<ClassSchedule> classSchedules = findClassSchedule(arrangementId);
        List<Question> questions = onlineClassTest.getQuestions();
        List<Integer> questionIds = new ArrayList<>();
        for (Question q : questions) {
            questionIds.add(q.getQuestionId());
        }
        List<Question> persistedQuestions = questionJpaDao.findByQuestionIdIsIn(questionIds);
        onlineClassTest.setQuestions(persistedQuestions);
        onlineClassTest.setArrangement(teacherArrangement);
        onlineClassTestJpaDao.saveAndFlush(onlineClassTest);
        return onlineClassTest;
    }

    @Override
    public Notice findNewestNotices(Integer arrangementId) {
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);
        Set<Notice> notices0 = teacherArrangement.getNotices();
        List<Notice> notices1 = new ArrayList<Notice>(notices0);
        Collections.sort(notices1, new Comparator<Notice>() {
            @Override
            public int compare(Notice o1, Notice o2) {

                return o2.getEstablishedTime().toString().compareTo(
                        o1.getEstablishedTime().toString());
            }

        });
        Set<Notice> notices = new LinkedHashSet<Notice>(notices1);// 这里注意使用LinkedHashSet
        Iterator<Notice> it = notices.iterator();
        return it.next();

    }

    @Override
    public Attendance createAttendance(Integer arrangementId, Attendance attendance) {
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);
        attendance.setArrangement(teacherArrangement);
        attendanceJpaDao.saveAndFlush(attendance);
        teacherArrangementJpaDao.saveAndFlush(teacherArrangement);
        return attendance;
    }

    @Override
    public TeacherArrangement findArrangement(Integer arrangementId) {
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);
        return teacherArrangement;
    }

    @Override
    public List<OnlineClassTest> findAllOnlineClassTest(Integer arrangementId) {
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);
        Set<OnlineClassTest> onlineClassTest = teacherArrangement.getTests();
        return new ArrayList<>(onlineClassTest);
    }

    @Override
    public List<OnlineClassTest> findOpeningTests(Integer arrangementId) {
        TeacherArrangement arrangement = teacherArrangementJpaDao.findOne(arrangementId);
        Set<OnlineClassTest> onlineClassTests = arrangement.getTests();
        List<OnlineClassTest> tests = new ArrayList<>();
        Date date = new Date();
        for (OnlineClassTest test : onlineClassTests) {
            if (test.getDeadline().compareTo(date) >= 0) {
                tests.add(test);
            }
        }
        if (tests.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return tests;
    }

    @Override
    public List<OnlineClassTest> findTimeOutTests(Integer arrangementId) {
        TeacherArrangement arrangement = teacherArrangementJpaDao.findOne(arrangementId);
        Set<OnlineClassTest> onlineClassTests = arrangement.getTests();
        List<OnlineClassTest> tests = new ArrayList<>();
        Date date = new Date();
        for (OnlineClassTest test : onlineClassTests) {
            if (test.getDeadline().compareTo(date) < 0) {
                tests.add(test);
            }
        }
        if (tests.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return tests;

    }

    @Override
    public List<ClassSchedule> findClassSchedule(Integer arrangementId) {
        return new ArrayList<>(findArrangement(arrangementId).getSchedules());
    }

    @Override
    public List<ClassTime> findAllClassTime(Integer arrangementId) {
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);
        Set<ClassTime> classTime = teacherArrangement.getClassTimes();
        return new ArrayList<>(classTime);
    }

    @Override
    public List<CourseComment> findAllCourseComment(Integer arrangementId) {
//        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);
//        Set<CourseComment> courseComments = teacherArrangement.getCourseComments();
//        return courseComments;
        List<CourseComment> courseComments = courseCommentJpaDao.findAllCourseComment(arrangementId, "Course");
        for (CourseComment comment : courseComments) {
            System.out.println(comment.getCommentId());
        }
        return courseComments;
    }

    @Override
    public Course findCourse(Integer arrangementId) {
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);
        Course course = teacherArrangement.getCourse();
        return course;
    }

    @Override
    public List<Notice> findAllNotice(Integer arrangementId) {
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);

        Set<Notice> notices0 = teacherArrangement.getNotices();
        List<Notice> notices1 = new ArrayList<Notice>(notices0);
        return notices1;
    }

    @Override
    public Teacher findTeacher(Integer arrangementId) {
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);
        Teacher teacher = teacherArrangement.getTeacher();
        return teacher;
    }

    @Override
    public List<TeacherArrangement> findAllArrangements() {
        List<TeacherArrangement> list = teacherArrangementJpaDao.findAll();
        return list;
    }

    @Override
    public List<Courseware> findAllCoursewares(Integer arrangementId) {
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);
        Set<Courseware> courseware = teacherArrangement.getCoursewares();
        return new ArrayList<>(courseware);
    }

    @Override
    public TeacherArrangement updateArrangement(TeacherArrangement teacherArrangement) {
        teacherArrangementJpaDao.saveAndFlush(teacherArrangement);
        return teacherArrangement;
    }

    @Override
    public TeacherArrangement createArrangement(TeacherArrangement teacherArrangement) {
        Teacher teacher = teacherJpaDao.findOne(teacherArrangement.getTeacher().getUserId());
        Course course = courseJpaDao.findOne(teacherArrangement.getCourse().getCourseId());
        teacherArrangement.setCourse(course);
        teacherArrangement.setTeacher(teacher);
        return teacherArrangementJpaDao.saveAndFlush(teacherArrangement);
    }

    @Override
    public TeacherArrangement deleteArrangement(Integer arrangeId) {
        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangeId);
        teacherArrangementJpaDao.delete(teacherArrangement);
        return teacherArrangement;
    }

    @Override
    public OnlineClassTest findNewestTest(Integer arrangementId) {
        List<OnlineClassTest> tests = testsJpaDao.findNewestTest(arrangementId);
        if (tests.isEmpty())
            return null;
        else
            return tests.get(0);
    }

    //    @Override
//    public List<Homework> arrangeHomework(Integer arrangementId, Homework homework)
//    {
//        TeacherArrangement teacherArrangement = teacherArrangementJpaDao.findOne(arrangementId);
//        List<ClassSchedule> classSchedules = findClassSchedule(arrangementId);
//        List<Homework> homeworks = new ArrayList<>();
//        // 给该门课下的所有学生发布一次作业;
//        homework.setSubmitted(false);
//        homework.setEstablishedTime(new Date());
//        for (ClassSchedule s : classSchedules)
//        {
//            Homework perHomework = new Homework();
//            BeanUtils.copyProperties(homework, perHomework, "homeworkId");
//            perHomework.setSchedule(s);
//            homeworkJpaDao.save(perHomework);
//            homeworks.add(perHomework);
//        }
//        return homeworks;
//    }
    @Override
    public Homework arrangeHomework(Integer arrangementId, Homework homework) {
        homework.setEstablishedTime(new Date());
        homework.setArrangement(findArrangement(arrangementId));
        return homeworkJpaDao.saveAndFlush(homework);
    }

    @Override
    public List<Homework> findAllHomework(Integer arrangementId) {
        return homeworkJpaDao.findByArrangementOrderByEstablishedTimeAsc(findArrangement(arrangementId));
    }

    @Override
    public List<Student> findAllUnSubmittedStudents(Integer arrangementId, Integer homeworkId) {
//        Set<HomeworkRecord> homeworkRecords = homeworkJpaDao.findOne(homeworkId).getHomeworkRecords();
        //该门课下的所有学生
        List<Student> students = classScheduleJpaDao.findStudentsOfSchedulesByTeacherArrangement(findArrangement(arrangementId));
        //已交作业的学生
        List<Student> submittedStudents = findAllSubmittedStudents(arrangementId,homeworkId);
        List<Student> unsubmiitedStudents = new ArrayList<>();
        //如果当前交了的作业的学生是0,则改班级下的所有学生都未交作业;
        if (submittedStudents.isEmpty()) {
            return students;
        }
        for (Student student : students) {
            for (Student subStudent : submittedStudents) {
                if (!student.getStudentId().equals(subStudent.getStudentId())) {
                    unsubmiitedStudents.add(student);
                }
            }
        }
        return unsubmiitedStudents;
    }

    @Override
    public List<Student> findAllSubmittedStudents(Integer arrangementId, Integer homeworkId) {
        return homeworkRecordJpaDao.findStudentsOfRecordByHomework(homeworkJpaDao.findOne(homeworkId));
    }

}
