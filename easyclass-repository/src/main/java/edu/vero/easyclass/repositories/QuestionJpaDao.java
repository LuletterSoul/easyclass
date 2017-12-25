package edu.vero.easyclass.repositories;


import edu.vero.easyclass.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  23:52 2017/12/14.
 * @since easyclass
 */

public interface QuestionJpaDao extends JpaRepository<Question,Integer> {

    List<Question> findByQuestionIdIsIn(Collection<Integer> questionIds);
}