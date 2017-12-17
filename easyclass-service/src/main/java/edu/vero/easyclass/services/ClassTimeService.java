package edu.vero.easyclass.services;

import edu.vero.easyclass.domain.ClassTime;
import edu.vero.easyclass.domain.TeacherComment;

import java.util.List;

public interface ClassTimeService {


    public List<TeacherComment> findAllTeacherComment(Integer timeId);



    public ClassTime findClassTime(Integer timeId);


    public List<ClassTime> findAllClassTimes();
}
