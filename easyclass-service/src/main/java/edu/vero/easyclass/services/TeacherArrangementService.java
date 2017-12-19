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

    /**
     * @param arrangementId
     * @param notice
     * @return
     */
    public Notice createNotice(Integer arrangementId, Notice notice);

    public OnlineClassTest createOnlineClassTest(Integer arrangementId,
                                                 OnlineClassTest onlineClassTest);

    public Notice findNewestNotices(Integer arrangementId);

    public Attendance createAttendance(Integer arrangementId, Attendance attendance);

    public TeacherArrangement findArrangement(Integer arrangementId);

    public List<OnlineClassTest> findAllOnlineClassTest(Integer arrangementId);

    public List<ClassTime> findAllClassTime(Integer arrangementId);

    public List<CourseComment> findAllCourseComment(Integer arrangementId);

    public Course findCourse(Integer arrangementId);

    public List<Notice> findAllNotice(Integer arrangementId);

    public Teacher findTeacher(Integer arrangementId);

    public List<TeacherArrangement> findAllArrangements();

    public List<Courseware> findAllCoursewares(Integer arrangementId);

    public List<CourseComment> findAllCourseComments(Integer arrangementId);


}
