package edu.vero.easyclass.repositories;

import edu.vero.easyclass.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteJpaDao extends JpaRepository<Vote,Integer>{
}
