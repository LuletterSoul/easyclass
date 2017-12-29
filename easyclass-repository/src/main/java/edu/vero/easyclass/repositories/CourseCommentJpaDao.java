package edu.vero.easyclass.repositories;

import edu.vero.easyclass.domain.CourseComment;
import edu.vero.easyclass.domain.TeachingComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  12:12 2017/12/19.
 * @since easyclass
 */

public interface CourseCommentJpaDao extends JpaRepository<CourseComment,Integer> {
    @Query(value = "SELECT * FROM teaching_comment where arrangementId=?1 AND commentLevel=?2",nativeQuery = true)
    List<CourseComment> findAllCourseComment(Integer arrangementId,String type);

//    @Query(value = "insert \n" +
//            "    into\n" +
//            "        teaching_comment\n" +
//            "        (score, arrangementId, commentLevel) \n" +
//            "    values\n" +
//            "        (?, ?, 'Course')",nativeQuery = true)
//    public CourseComment insertComment(Integer )
}
