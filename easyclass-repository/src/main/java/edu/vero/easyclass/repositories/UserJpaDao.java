package edu.vero.easyclass.repositories;

import edu.vero.easyclass.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  12:33 2017/12/11.
 * @since easyclass
 */

@Repository
public interface UserJpaDao extends JpaRepository<User, Long> {


}
