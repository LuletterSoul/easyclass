package edu.vero.easyclass.repositories;

import edu.vero.easyclass.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseJpaDao extends JpaRepository<Course,Integer>{
}
