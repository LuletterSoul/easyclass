package edu.vero.easyclass.repositories;

import edu.vero.easyclass.domain.TeacherArrangement;
import org.springframework.data.jpa.repository.JpaRepository;;

import java.util.List;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  0:05 2017/12/15.
 * @since easyclass
 */

public interface TeacherArrangementJpaDao extends JpaRepository<TeacherArrangement,Integer>{
}
