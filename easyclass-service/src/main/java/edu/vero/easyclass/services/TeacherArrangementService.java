package edu.vero.easyclass.services;


import edu.vero.easyclass.domain.Courseware;
import edu.vero.easyclass.domain.Notice;
import edu.vero.easyclass.domain.TeacherArrangement;
import edu.vero.easyclass.domain.*;

import java.util.List;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 0:11 2017/12/15.
 * @since easyclass
 */

public interface TeacherArrangementService
{

    Notice createNotice(Integer arrangementId, Notice notice);

    OnlineClassTest createOnlineClassTest(Integer arrangementId,
                                                 OnlineClassTest onlineClassTest);

    Notice findNewestNotices(Integer arrangementId);

    Attendance createAttendance(Integer arrangementId, Attendance attendance);

    TeacherArrangement findArrangement(Integer arrangementId);

    List<OnlineClassTest> findAllOnlineClassTest(Integer arrangementId);

    List<OnlineClassTest> findOpeningTests(Integer arrangementId);

    List<OnlineClassTest> findTimeOutTests(Integer arrangementId);

    List<ClassSchedule> findClassSchedule(Integer arrangementId);

    List<ClassTime> findAllClassTime(Integer arrangementId);

    List<CourseComment> findAllCourseComment(Integer arrangementId);

    Course findCourse(Integer arrangementId);

    List<Notice> findAllNotice(Integer arrangementId);

    Teacher findTeacher(Integer arrangementId);

    List<TeacherArrangement> findAllArrangements();

    List<Courseware> findAllCoursewares(Integer arrangementId);

    TeacherArrangement updateArrangement(TeacherArrangement teacherArrangement);

    TeacherArrangement createArrangement(TeacherArrangement teacherArrangement);

    TeacherArrangement deleteArrangement(Integer arrangeId);

    OnlineClassTest findNewestTest(Integer arrangementId);

    Homework arrangeHomework(Integer homeworkId, Homework homework);

    List<Homework> findAllHomework(Integer arrangementId);

    List<Student> findAllUnSubmittedStudents(Integer arrangementId,Integer homeworkId);

    List<Student> findAllSubmittedStudents(Integer arrangementId,Integer homeworkId);
}
