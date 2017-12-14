package edu.vero.easyclass.controllers;

import edu.vero.easyclass.domain.Notice;
import edu.vero.easyclass.services.TeacherArrangementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  0:09 2017/12/15.
 * @since easyclass
 */

@RestController
@RequestMapping(value = "/arrangements")
public class TeacherArrangementController {

    private TeacherArrangementService teacherArrangementService;

    @Autowired
    public void setTeacherArrangementService(TeacherArrangementService teacherArrangementService) {
        this.teacherArrangementService = teacherArrangementService;
    }


    /**
     * 通过教师安排表的Id，新建旗下的一个公告，并建立对应的关联
     * @param arrangementId 教师安排表的Id
     * @param notice 教师要新建的公告
     * @return 公告实体，返回201状态码，表明公告创建成功
     */
    @PostMapping(value = "/{arrangementId}/notices")
    public ResponseEntity<Notice> createNotice(@PathVariable("arrangementId") Integer arrangementId,@RequestBody Notice notice){
        return new ResponseEntity<>(teacherArrangementService.createNotice(arrangementId, notice), HttpStatus.CREATED);
    }
}
