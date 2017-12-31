package edu.vero.easyclass.services;


import edu.vero.easyclass.domain.Homework;
import edu.vero.easyclass.domain.HomeworkRecord;
import io.swagger.models.auth.In;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public interface HomeworkService
{

    public Homework deleteHomework(Integer homeworkId);

    public Homework updateHomework(Homework homework);

    public Homework createHomework(Homework homework);

    public List<Homework> findAllHomeworks();

    Homework uploadHomework(Integer scheduleId,Integer homeworkId, MultipartFile file, HttpServletRequest request);

    HomeworkRecord downloadHomework(Integer homeworkId, HttpServletResponse response);

}
