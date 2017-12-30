package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Course;
import edu.vero.easyclass.domain.Courseware;
import edu.vero.easyclass.services.CoursewareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.util.List;


@Api(description = "上课时间节点业务")
@RestController
@RequestMapping(value = "/courseware")
public class CoursewareController
{
    private CoursewareService coursewareService;

    @Autowired
    public void setCoursewareService(CoursewareService coursewareService)
    {
        this.coursewareService = coursewareService;
    }

    @ApiOperation(value = "找到全部的课件（测试通过）")
    @GetMapping(value = "")
    public ResponseEntity<List<Courseware>> findAllCoursewares()
    {
        return new ResponseEntity<>(coursewareService.findAllCourseWare(), HttpStatus.OK);
    }

    @ApiOperation(value = "根据id找到课件（测试通过）")
    @GetMapping(value = "/{coursewareId}")
    public ResponseEntity<Courseware> findCourseware(@PathVariable("coursewareId") Integer coursewareId)
    {
        return new ResponseEntity<>(coursewareService.findCourseWare(coursewareId), HttpStatus.OK);
    }

    @ApiOperation(value = "创建课件，课件的上传（测试通过）")
    @PostMapping(value = "")
    public ResponseEntity<Courseware> createCourseware(@RequestParam("arrangementId") Integer arrangeId,
                                                       @RequestParam("file") MultipartFile multipartFile,
                                                       HttpServletRequest request)
    {
        return new ResponseEntity<>(coursewareService.createCourseware(arrangeId,multipartFile,request), HttpStatus.OK);

    }

    @ApiOperation(value = "更新课件信息（测试通过）")
    @PutMapping(value = "")
    public ResponseEntity<Courseware> updateCourseware(@RequestBody Courseware courseware)
    {
        return new ResponseEntity<>(coursewareService.updateCourseware(courseware),
            HttpStatus.CREATED);
    }

    @ApiOperation(value = "根据id删除课件（测试通过）")
    @DeleteMapping(value = "/{coursewareId}")
    public ResponseEntity<Courseware> deleteCourseware(@PathVariable("coursewareId") Integer coursewareId)
    {
        return new ResponseEntity<>(coursewareService.deleteCourseware(coursewareId),
            HttpStatus.OK);
    }

    @ApiOperation(value = "课件下载（下载完成 还是像作业上传下载一样都是utf-8编码）")
    @GetMapping(value = "/{coursewareId}/download")
    public ResponseEntity<Courseware> downloadCourseware(@PathVariable("coursewareId") Integer coursewareId, HttpServletRequest request, HttpServletResponse response){
        return new ResponseEntity<>(coursewareService.downloadCourseware(coursewareId,request,response),HttpStatus.OK);
    }
}