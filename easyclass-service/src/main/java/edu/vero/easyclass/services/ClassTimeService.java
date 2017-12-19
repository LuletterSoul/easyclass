package edu.vero.easyclass.services;


import edu.vero.easyclass.domain.ClassTime;
import edu.vero.easyclass.domain.ClassTimeComment;
import edu.vero.easyclass.domain.TeachingComment;

import java.util.List;


public interface ClassTimeService
{

//    List<TeachingComment> findAllTeacherComment(Integer timeId);

    ClassTime findClassTime(Integer timeId);

    List<ClassTime> findAllClassTimes();

    ClassTimeComment savePerClassComment(Integer timeId, ClassTimeComment comment);

    List<ClassTimeComment> findAllClassComments(Integer timeId);

}
