package edu.vero.easyclass.services;

import edu.vero.easyclass.domain.Homework;

import java.util.List;

public interface HomeworkService {

    public Homework deleteHomework( Integer homeworkId);


    public List<Homework> findAllHomeworks();

}
