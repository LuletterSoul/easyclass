package edu.vero.easyclass.services;

import edu.vero.easyclass.domain.SignRecord;
import edu.vero.easyclass.domain.Attendance;
import edu.vero.easyclass.domain.ClassSchedule;

import java.util.List;

public interface SignRecordService{
  public List<SignRecord> findAllSignRecord();
  public Attendance findAttendence(Integer signId);
  public ClassSchedule findClassSchedule(Integer signId);

}