package edu.vero.easyclass.repositories;


import edu.vero.easyclass.domain.ClassSchedule;
import edu.vero.easyclass.domain.OnlineClassTest;
import edu.vero.easyclass.domain.TestRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface ClassScheduleJpaDao extends JpaRepository<ClassSchedule, Integer>,JpaSpecificationExecutor<ClassSchedule>
{
//    List<TestRecord> findTestRecordsById(Integer scheduleId);
}
