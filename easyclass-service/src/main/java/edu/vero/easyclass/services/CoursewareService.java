package edu.vero.easyclass.services;

import edu.vero.easyclass.domain.Courseware;


import java.util.List;

public interface CoursewareService {
    public List<Courseware>findAllCourseWare();
    public Courseware findCourseWare(Integer coursewareId);
}