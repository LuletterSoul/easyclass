package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Homework;
import edu.vero.easyclass.domain.HomeworkRecord;
import edu.vero.easyclass.services.HomeworkService;
import io.swagger.annotations.*;
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

    @ApiOperation(value = "删除作业（待添加服务器端作业文件删除）")
    @DeleteMapping(value = "/{homeworkId}")
    public ResponseEntity<Homework> deleteHomework(@PathVariable("homeworkId") Integer homeworkId)
    {
        return new ResponseEntity<>(homeworkService.deleteHomework(homeworkId),
            HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "查找全部的作业（测试通过）")
    @GetMapping(value = "")
    public ResponseEntity<List<Homework>> findAllHomeworks()
    {
        return new ResponseEntity<>(homeworkService.findAllHomeworks(), HttpStatus.OK);
    }

    @ApiOperation(value = "更新作业（测试通过）")
    @PutMapping(value = "")
    public ResponseEntity<Homework> updateHomework(@RequestBody Homework homework)
    {
        return new ResponseEntity<>(homeworkService.updateHomework(homework), HttpStatus.OK);
    }

    @ApiOperation(value = "创建作业（测试通过）")
    @PostMapping(value = "")
    public ResponseEntity<Homework> createHomework(@RequestBody Homework homework)
    {
        return new ResponseEntity<>(homeworkService.createHomework(homework), HttpStatus.CREATED);
    }

    @ApiOperation(value = "学生提交作业(通过测试)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "homeworkId", value = "任务编号", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "scheduleId", value = "课表编号", dataType = "int", paramType = "query", required = true)})
    @PostMapping(value = "/{homeworkId}")
    public ResponseEntity<Homework> uploadHomework(@PathVariable("homeworkId") Integer homeworkId,@RequestParam("scheduleId") Integer scheduleId,
                                                   @RequestParam("file") MultipartFile file, HttpServletRequest request)
    {
        return new ResponseEntity<>(homeworkService.uploadHomework(scheduleId,homeworkId, file,request), HttpStatus.CREATED);
    }
    @ApiOperation(value = "下载上传到服务器的作业（正常下载，但是下载后UTF-8返回直接打开还是乱码，需要进一步测试）")
    @GetMapping(value = "/{homeworkId}/download")
    public ResponseEntity<HomeworkRecord> downloadHomework(@PathVariable("homeworkId") Integer homeworkId, HttpServletRequest request, HttpServletResponse response){
        return new ResponseEntity<HomeworkRecord>(homeworkService.downloadHomework(homeworkId,response),HttpStatus.OK);
    }
}
