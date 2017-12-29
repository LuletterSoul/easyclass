package edu.vero.easyclass.repositories;

import edu.vero.easyclass.domain.Course;
import edu.vero.easyclass.domain.CourseComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseJpaDao extends JpaRepository<Course,Integer>{

}
