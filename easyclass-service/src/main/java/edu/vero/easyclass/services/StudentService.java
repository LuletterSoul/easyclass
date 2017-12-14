package edu.vero.easyclass.services;

import edu.vero.easyclass.domain.Student;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  20:52 2017/12/14.
 * @since easyclass
 */

public interface StudentService {
    Student findStudentById(Integer userId);
}
