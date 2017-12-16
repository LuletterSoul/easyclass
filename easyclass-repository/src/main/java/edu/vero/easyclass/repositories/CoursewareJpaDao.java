package edu.vero.easyclass.repositories;

import edu.vero.easyclass.domain.Courseware;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursewareJpaDao extends JpaRepository<Courseware,Integer> {
   // @Query("from Courseware c where c.")

}