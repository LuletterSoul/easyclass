package edu.vero.easyclass.services;


import edu.vero.easyclass.domain.Homework;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface HomeworkService
{

    public Homework deleteHomework(Integer homeworkId);

    public Homework updateHomework(Homework homework);

    public Homework createHomework(Homework homework);

    public List<Homework> findAllHomeworks();

    Homework uploadHomework(Integer homeworkId, MultipartFile file, HttpServletRequest request);

}
