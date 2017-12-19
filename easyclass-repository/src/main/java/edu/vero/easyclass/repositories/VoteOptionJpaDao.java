package edu.vero.easyclass.repositories;

import edu.vero.easyclass.domain.VoteOption;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  11:25 2017/12/19.
 * @since easyclass
 */

public interface VoteOptionJpaDao extends JpaRepository<VoteOption,Integer> {
}
