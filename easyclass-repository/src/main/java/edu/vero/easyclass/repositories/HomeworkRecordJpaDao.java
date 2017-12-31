package edu.vero.easyclass.repositories;

import edu.vero.easyclass.domain.HomeworkRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  18:12 2017/12/31.
 * @since easyclass
 */

public interface HomeworkRecordJpaDao extends JpaRepository<HomeworkRecord, Integer> {

}
