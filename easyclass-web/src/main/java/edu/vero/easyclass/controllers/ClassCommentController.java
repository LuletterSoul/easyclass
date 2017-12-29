package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.ClassTimeComment;
import edu.vero.easyclass.services.ClassCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(description = "课后评教业务")
@RestController
@RequestMapping(value = "/class_comments")
public class ClassCommentController
{
    private ClassCommentService classCommentService;

    @Autowired
    public void setClassCommentService(ClassCommentService classCommentService)
    {
        this.classCommentService = classCommentService;
    }

    @ApiOperation(value = "给每节课提交评教(通过测试)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "timeId", value = "教师安排表编号", dataType = "int", paramType = "query", required = true),
        @ApiImplicitParam(name = "scheduleId", value = "课表编号", dataType = "int", paramType = "query", required = true)})
    @PostMapping
    public ResponseEntity<ClassTimeComment> postClassComment(@RequestParam("timeId") Integer timeId,
                                                             @RequestParam("scheduleId") Integer scheduleId,
                                                             @RequestBody ClassTimeComment comment)
    {
        return new ResponseEntity<>(classCommentService.save(timeId, scheduleId, comment),
            HttpStatus.CREATED);
    }
}
