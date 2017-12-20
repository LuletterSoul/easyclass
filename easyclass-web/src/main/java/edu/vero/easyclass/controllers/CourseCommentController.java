package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.CourseComment;
import edu.vero.easyclass.services.CourseCommentService;
import edu.vero.easyclass.services.CourseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "课程评教")
@RestController(value = "/course_comment")
public class CourseCommentController {
    private CourseCommentService courseCommentService;

    @Autowired
    public void setCourseCommentService(CourseCommentService courseCommentService) {
        this.courseCommentService = courseCommentService;
    }

    @PostMapping
    public ResponseEntity<CourseComment> postCourseComent(@RequestBody  CourseComment comment, @RequestParam("arrangeId") Integer arrangeId, @RequestParam("scheduled") Integer scheduleId){
        return new ResponseEntity<>(courseCommentService.save(arrangeId,scheduleId,comment), HttpStatus.CREATED);
    }
}
