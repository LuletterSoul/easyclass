package edu.vero.easyclass.repositories;


import edu.vero.easyclass.domain.TestRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TestRecordJpaDao extends JpaRepository<TestRecord, Integer>
{
//    @Query(value = "select TestRecord from TestRecord r where r.schedule.,")
//    List<Integer> findAllByScheduleId(Integer scheduleId);

    @Query(value = "select * from test_record t where t.testId = ?1",nativeQuery = true)
    List<TestRecord> findAllRecordByTestId(Integer testId);
}