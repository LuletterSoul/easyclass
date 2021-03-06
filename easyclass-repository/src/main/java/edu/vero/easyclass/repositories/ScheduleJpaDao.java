package edu.vero.easyclass.repositories;


import edu.vero.easyclass.domain.ClassSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  23:52 2017/12/14.
 * @since easyclass
 */

public interface ScheduleJpaDao extends JpaRepository<ClassSchedule,Integer> {
}