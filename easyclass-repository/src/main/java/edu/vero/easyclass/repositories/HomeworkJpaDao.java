package edu.vero.easyclass.repositories;


import edu.vero.easyclass.domain.Homework;
import edu.vero.easyclass.domain.TeacherArrangement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface HomeworkJpaDao extends JpaRepository<Homework, Integer>
{
    public List<Homework> findByArrangementOrderByEstablishedTimeAsc(@Param("arrangement") TeacherArrangement arrangement);
}
