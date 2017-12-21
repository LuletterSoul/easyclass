package edu.vero.easyclass.services;

import edu.vero.easyclass.domain.Homework;

import java.util.List;

public interface HomeworkService {

    public Homework deleteHomework( Integer homeworkId);
    public Homework updateHomework(Homework  homework);
    public Homework createHomework(  Homework  homework);
    public List<Homework> findAllHomeworks();

}
