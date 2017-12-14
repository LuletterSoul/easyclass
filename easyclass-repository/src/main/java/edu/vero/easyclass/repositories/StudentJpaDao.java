package edu.vero.easyclass.repositories;

import edu.vero.easyclass.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  20:50 2017/12/14.
 * @since easyclass
 */

public interface StudentJpaDao extends JpaRepository<Student,Integer> {

}
