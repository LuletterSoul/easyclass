package edu.vero.easyclass.repositories;

import edu.vero.easyclass.domain.Homework;
import edu.vero.easyclass.domain.HomeworkRecord;
import edu.vero.easyclass.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  18:12 2017/12/31.
 * @since easyclass
 */

public interface HomeworkRecordJpaDao extends JpaRepository<HomeworkRecord, Integer> {

    @Query(value = "select r.schedule.student from HomeworkRecord r where r.homework = ?1")
    List<Student> findStudentsOfRecordByHomework(Homework homework);

}
