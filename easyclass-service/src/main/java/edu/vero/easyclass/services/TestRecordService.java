package edu.vero.easyclass.services;

import edu.vero.easyclass.domain.TestRecord;
import edu.vero.easyclass.domain.ClassSchedule;
import edu.vero.easyclass.domain.OnlineClassTest;
import org.aspectj.weaver.ast.Test;

import java.util.List;

public interface TestRecordService {
    public List<TestRecord> findAllTestRecords();
    public TestRecord createTestRecord(TestRecord testRecord);
    public ClassSchedule findClassSchedule(Integer recordId);
    public OnlineClassTest findTest(Integer recordId);
}
