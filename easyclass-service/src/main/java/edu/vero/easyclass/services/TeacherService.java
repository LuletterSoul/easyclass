package edu.vero.easyclass.services;


import edu.vero.easyclass.domain.TeacherArrangement;
import edu.vero.easyclass.domain.Teacher;

import java.util.List;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 23:59 2017/12/14.
 * @since easyclass
 */

public interface TeacherService
{
    public List<Teacher> findAllTeachers();

    public Teacher findTeacher(Integer userId);

    public List<TeacherArrangement> findTeacherArrangement(Integer userId);

    public List<TeacherArrangement> createTeacherArrangement(Integer userId,
                                                             List<TeacherArrangement> list);
}
