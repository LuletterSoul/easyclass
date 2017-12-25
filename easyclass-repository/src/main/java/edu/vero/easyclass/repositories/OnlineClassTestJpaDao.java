package edu.vero.easyclass.repositories;


import edu.vero.easyclass.domain.OnlineClassTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OnlineClassTestJpaDao extends JpaRepository<OnlineClassTest, Integer>
{
    List<OnlineClassTest> findByTestIdNotInAndTestIdIn(List<Integer> doneTestIds,
                                                       List<Integer> echoedTestIds);

}