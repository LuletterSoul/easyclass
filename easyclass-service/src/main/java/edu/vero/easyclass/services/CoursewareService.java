package edu.vero.easyclass.services;


import edu.vero.easyclass.domain.Courseware;

import java.util.List;


public interface CoursewareService
{
     List<Courseware> findAllCourseWare();

     Courseware findCourseWare(Integer coursewareId);

     Courseware createCourseware(Courseware courseware);

     Courseware deleteCourseware(Integer CoursewareId);

     Courseware updateCourseware(Courseware courseware);
}