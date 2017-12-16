package edu.vero.easyclass.repositories;

import edu.vero.easyclass.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherJpaDao extends JpaRepository<Teacher,Integer> {

}