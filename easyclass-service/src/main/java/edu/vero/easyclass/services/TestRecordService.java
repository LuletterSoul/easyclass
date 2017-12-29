package edu.vero.easyclass.services;


import edu.vero.easyclass.domain.TestRecord;
import edu.vero.easyclass.domain.ClassSchedule;
import edu.vero.easyclass.domain.OnlineClassTest;
import org.aspectj.weaver.ast.Test;

import java.util.List;


public interface TestRecordService
{
    List<TestRecord> findAllTestRecords();

    TestRecord createTestRecord(TestRecord testRecord);

    ClassSchedule findClassSchedule(Integer recordId);

    OnlineClassTest findTest(Integer recordId);

    TestRecord deleteTestRecord(Integer TestRecordId);

    TestRecord updateTestRecord(TestRecord question);
}
