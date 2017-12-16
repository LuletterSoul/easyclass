package edu.vero.easyclass.repositories;

import edu.vero.easyclass.domain.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceJpaDao extends JpaRepository<Attendance,Integer>{
}
