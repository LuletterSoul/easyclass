package edu.vero.easyclass.repositories;

import edu.vero.easyclass.domain.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeworkJpaDao extends JpaRepository<Homework,Integer> {

}
