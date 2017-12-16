package edu.vero.easyclass.controllers;

import edu.vero.easyclass.domain.Courseware;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/courseware")
public class CoursewareController{
    @GetMapping(value = "")
    public ResponseEntity< List <Courseware> > findAllCoursewares(){
        return  null;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Courseware> findCourseware(@PathVariable("id")Integer id){
        return  null;
    }
}