package edu.vero.easyclass.services;

import edu.vero.easyclass.domain.CourseComment;

public interface CourseCommentService {
    CourseComment save(Integer arrangeId,Integer schduleId,CourseComment comment);
}
