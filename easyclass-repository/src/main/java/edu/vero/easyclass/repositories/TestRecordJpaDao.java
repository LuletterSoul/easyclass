package edu.vero.easyclass.repositories;

import edu.vero.easyclass.domain.TestRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRecordJpaDao extends JpaRepository<TestRecord,Integer> {


}