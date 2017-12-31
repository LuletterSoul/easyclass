package edu.vero.easyclass.repositories;


import edu.vero.easyclass.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface ClassScheduleJpaDao extends JpaRepository<ClassSchedule, Integer>,
        JpaSpecificationExecutor<ClassSchedule>
{
    // List<TestRecord> findTestRecordsById(Integer scheduleId);
    @Query(value = "select c.student from ClassSchedule c where c.teacherArrangement = ?1")
    List<Student> findStudentsOfSchedulesByTeacherArrangement(TeacherArrangement teacherArrangement);
}
