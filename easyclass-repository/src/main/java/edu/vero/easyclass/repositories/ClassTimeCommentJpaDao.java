package edu.vero.easyclass.repositories;


import edu.vero.easyclass.domain.ClassTimeComment;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 12:57 2017/12/19.
 * @since easyclass
 */

public interface ClassTimeCommentJpaDao extends JpaRepository<ClassTimeComment, Integer>
{

}
