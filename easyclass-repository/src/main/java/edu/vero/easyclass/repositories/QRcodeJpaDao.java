package edu.vero.easyclass.repositories;

import edu.vero.easyclass.domain.QRcode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QRcodeJpaDao extends JpaRepository<QRcode,Integer>{
}
