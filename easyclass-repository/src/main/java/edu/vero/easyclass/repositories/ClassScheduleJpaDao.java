package edu.vero.easyclass.repositories;

import edu.vero.easyclass.domain.ClassSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassScheduleJpaDao extends JpaRepository<ClassSchedule,Integer>{

    @Query(value = "select * from class_schedule c where c.studentId=?1",nativeQuery = true)
    List<ClassSchedule> findAllSchedule(Integer stuid);
}
