package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.CourseComment;
import edu.vero.easyclass.services.CourseCommentService;
import edu.vero.easyclass.services.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(description = "课程总评业务")
@RestController
@RequestMapping(value = "/course_comments")
public class CourseCommentController
{
    private CourseCommentService courseCommentService;

    @Autowired
    public void setCourseCommentService(CourseCommentService courseCommentService)
    {
        this.courseCommentService = courseCommentService;
    }

    @ApiOperation(value = "给每门课程提交总评(测试通过)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "arrangeId", value = "教师安排表编号", dataType = "int", paramType = "query"),
        @ApiImplicitParam(name = "scheduleId", value = "课表编号", dataType = "int", paramType = "query")})
    @PostMapping
    public ResponseEntity<CourseComment> postCourseComment(@RequestBody CourseComment comment,
                                                           @RequestParam("arrangeId") Integer arrangeId,
                                                           @RequestParam("scheduleId") Integer scheduleId)
    {
        return new ResponseEntity<>(courseCommentService.save(arrangeId, scheduleId, comment),
            HttpStatus.CREATED);
    }
}
