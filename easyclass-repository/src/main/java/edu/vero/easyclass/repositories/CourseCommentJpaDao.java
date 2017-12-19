package edu.vero.easyclass.repositories;

import edu.vero.easyclass.domain.CourseComment;
import edu.vero.easyclass.domain.TeachingComment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  12:12 2017/12/19.
 * @since easyclass
 */

public interface CourseCommentJpaDao extends JpaRepository<CourseComment,Integer> {
}
