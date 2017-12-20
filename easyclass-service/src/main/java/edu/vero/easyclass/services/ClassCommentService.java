package edu.vero.easyclass.services;

import edu.vero.easyclass.domain.ClassTimeComment;

public interface ClassCommentService {
    ClassTimeComment save(Integer timeId,Integer scheduleId,ClassTimeComment comment);
}
