package edu.vero.easyclass.repositories;


import edu.vero.easyclass.domain.ClassTime;
import edu.vero.easyclass.domain.TeachingComment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClassTimeJpaDao extends JpaRepository<ClassTime, Integer>
{

}