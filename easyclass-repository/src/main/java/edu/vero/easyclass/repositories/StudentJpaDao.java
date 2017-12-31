package edu.vero.easyclass.repositories;

import edu.vero.easyclass.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  0:07 2017/12/18.
 * @since easyclass
 */

public interface StudentJpaDao extends JpaRepository<Student,Integer> {
}
