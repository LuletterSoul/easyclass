package edu.vero.easyclass.repositories;


import edu.vero.easyclass.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 0:06 2017/12/18.
 * @since easyclass
 */

public interface NoticeJpaDao extends JpaRepository<Notice, Integer>
{}
