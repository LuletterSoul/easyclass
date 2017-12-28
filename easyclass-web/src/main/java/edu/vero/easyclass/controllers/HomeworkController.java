package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Homework;
import edu.vero.easyclass.services.HomeworkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Api(description = "作业业务")
@RestController
@RequestMapping(value = "/homeworks")
public class HomeworkController
{
    private HomeworkService homeworkService;

    @Autowired
    public void setHomeworkService(HomeworkService homeworkService)
    {
        this.homeworkService = homeworkService;
    }

    @DeleteMapping(value = "/{homeworkId}")
    public ResponseEntity<Homework> deleteHomework(@PathVariable("homeworkId") Integer homeworkId)
    {
        return new ResponseEntity<>(homeworkService.deleteHomework(homeworkId),
            HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Homework>> findAllHomeworks()
    {
        return new ResponseEntity<>(homeworkService.findAllHomeworks(), HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<Homework> updateHomework(@RequestBody Homework homework)
    {
        return new ResponseEntity<>(homeworkService.updateHomework(homework), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Homework> createHomework(@RequestBody Homework homework)
    {
        return new ResponseEntity<>(homeworkService.createHomework(homework), HttpStatus.CREATED);
    }

    @ApiModelProperty(value = "学生提交作业(通过测试)")
    @PostMapping(value = "/{homeworkId}")
    public ResponseEntity<Homework> uploadHomework(@PathVariable("homeworkId") Integer homeworkId,
                                                   @RequestParam("file") MultipartFile file, HttpServletRequest request)
    {
        return new ResponseEntity<>(homeworkService.uploadHomework(homeworkId, file,request), HttpStatus.CREATED);
    }
    @ApiModelProperty(value = "下载上传到服务器的作业")
    @GetMapping(value = "/{homeworkId}/download")
    public ResponseEntity<Homework> downloadHomework(@PathVariable("homeworkId") Integer homeworkId, HttpServletRequest request, HttpServletResponse response){
        return new ResponseEntity<Homework>(homeworkService.downloadHomework(homeworkId,response),HttpStatus.OK);
    }
}
