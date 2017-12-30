package edu.vero.easyclass.controllers;

import edu.vero.easyclass.services.HomeworkRecordService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(description = "作业记录业务")
@RestController
@RequestMapping(value = "/homeworkrecords")
public class HomeworkRecordController {
    private HomeworkRecordService homeworkRecordService;

    @Autowired
    public void setHomeworkRecordService(HomeworkRecordService homeworkRecordService)
    {
        this.homeworkRecordService = homeworkRecordService;
    }


}
