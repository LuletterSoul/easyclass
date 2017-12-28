package edu.vero.easyclass.repositories;

import edu.vero.easyclass.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoteJpaDao extends JpaRepository<Vote,Integer>{
//    @Query(value = "select * from vote v where v.establishedTime=(select max(establishedTime) from vote v1 where v1.attendanceId=?1)",nativeQuery = true)
//    List<Vote> findNewestVote(Integer attendanceId);
}
