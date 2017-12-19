package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.*;
import edu.vero.easyclass.services.TeacherArrangementService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 0:09 2017/12/15.
 * @since easyclass
 */
@Api(description = "教师安排表业务")
@RestController
@RequestMapping(value = "/arrangements")
public class TeacherArrangementController
{

    private TeacherArrangementService teacherArrangementService;

    @Autowired
    public void setTeacherArrangementService(TeacherArrangementService teacherArrangementService)
    {
        this.teacherArrangementService = teacherArrangementService;
    }

    /**
     * 通过教师安排表的Id，新建旗下的一个公告，并建立对应的关联
     *
     * @param arrangementId
     *            教师安排表的Id
     * @param notice
     *            教师要新建的公告
     * @return 公告实体，返回201状态码，表明公告创建成功
     */
    @PostMapping(value = "/{arrangementId}/notices")
    public ResponseEntity<Notice> createNotice(@PathVariable("arrangementId") Integer arrangementId,
                                               @RequestBody Notice notice)
    {
        return new ResponseEntity<>(teacherArrangementService.createNotice(arrangementId,  notice),
                HttpStatus.CREATED);
    }

    @PostMapping(value = "/{arrangementId}/tests")
    public ResponseEntity<OnlineClassTest> createOnlineClassTest(@PathVariable("arrangementId") Integer arrangementId,
                                                                 @RequestBody OnlineClassTest onlineClassTest)
    {
        return new ResponseEntity<>(teacherArrangementService.createOnlineClassTest(arrangementId,  onlineClassTest),
                HttpStatus.CREATED);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<TeacherArrangement>> findAllArrangements()
    {
        return new ResponseEntity<>(teacherArrangementService.findAllArrangements(),
            HttpStatus.OK);
    }

    @GetMapping(value = "/{arrangementId}/coursewares")
    public ResponseEntity<List<Courseware>> findAllCoursewares(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<>(teacherArrangementService.findAllCoursewares(arrangementId),
            HttpStatus.OK);
    }

    @GetMapping(value = "/{arrangementId}/notices/newest")
    public ResponseEntity<Notice> findNewestNotices(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<>(teacherArrangementService.findNewestNotices(arrangementId),
                HttpStatus.OK);
    }

    @PostMapping(value = "/{arrangementId}/attendances")
    public ResponseEntity<Attendance> createAttendance(@PathVariable("arrangementId") Integer arrangementId,
                                                       @RequestBody Attendance attendance)
    {
        return new ResponseEntity<>(teacherArrangementService.createAttendance(arrangementId,  attendance),
                HttpStatus.CREATED);
    }

    @GetMapping(value = "/{arrangementId}")
    public ResponseEntity<TeacherArrangement> findArrangement(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<>(teacherArrangementService.findArrangement(arrangementId),
                HttpStatus.OK);
    }

    @GetMapping(value = "/{arrangementId}/tests")
    public ResponseEntity<List<OnlineClassTest>> findAllOnlineClassTest(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<>(teacherArrangementService.findAllOnlineClassTest(arrangementId),
                HttpStatus.OK);
    }

    @GetMapping(value = "/{arrangementId}/times")
    public ResponseEntity<List<ClassTime>> findAllClassTime(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<>(teacherArrangementService.findAllClassTime(arrangementId),
                HttpStatus.OK);
    }

    @GetMapping(value = "/{arrangementId}/comments")
    public ResponseEntity<List<CourseComment>> findTeacherComment(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<>(teacherArrangementService.findAllCourseComment(arrangementId),
                HttpStatus.OK);
    }

    @GetMapping(value = "/{arrangementId}/course")
    public ResponseEntity<Course> findCourse(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<>(teacherArrangementService.findCourse(arrangementId),
                HttpStatus.OK);
    }

    @GetMapping(value = "/{arrangementId}/notices")
    public ResponseEntity<List<Notice>> findAllNotice(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<>(teacherArrangementService.findAllNotice(arrangementId),
                HttpStatus.OK);
    }

    @GetMapping(value = "/{arrangementId}/teacher")
    public ResponseEntity<Teacher> findTeacher(@PathVariable("arrangementId") Integer arrangementId)
    {
        return new ResponseEntity<>(teacherArrangementService.findTeacher(arrangementId),
                HttpStatus.OK);
    }
}
