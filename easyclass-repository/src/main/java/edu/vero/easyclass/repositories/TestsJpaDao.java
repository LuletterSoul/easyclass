package edu.vero.easyclass.repositories;


import edu.vero.easyclass.domain.OnlineClassTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  23:52 2017/12/14.
 * @since easyclass
 */

public interface TestsJpaDao extends JpaRepository<OnlineClassTest,Integer> {
    @Query(value = "select * from online_class_test as t where t.establishedTime=(select max(t1.establishedTime) from online_class_test as t1 where t1.arrangeId = ?1 )",
            nativeQuery = true)
    List<OnlineClassTest> findNewestTest(Integer arrangementId);
}