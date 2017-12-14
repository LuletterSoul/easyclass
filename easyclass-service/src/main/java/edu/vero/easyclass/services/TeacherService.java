package edu.vero.easyclass.services;

import edu.vero.easyclass.domain.Notice;
import edu.vero.easyclass.domain.Teacher;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  23:59 2017/12/14.
 * @since easyclass
 */

public interface TeacherService {

    public Teacher saveTeacher(Teacher teacher);

    public Notice createNotice(Integer userId,Integer arrangementId,Notice notice);
}
