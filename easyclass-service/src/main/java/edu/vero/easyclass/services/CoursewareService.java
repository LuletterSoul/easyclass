package edu.vero.easyclass.services;


import edu.vero.easyclass.domain.Courseware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public interface CoursewareService
{
     List<Courseware> findAllCourseWare();

     Courseware findCourseWare(Integer coursewareId);

     Courseware createCourseware(Integer arrangeId,MultipartFile multipartFile, HttpServletRequest request);

     Courseware downloadCourseware(Integer coursewareId, HttpServletRequest request,HttpServletResponse response);

     Courseware deleteCourseware(Integer CoursewareId);

     Courseware updateCourseware(Courseware courseware);
}