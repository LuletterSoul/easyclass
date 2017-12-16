package edu.vero.easyclass.repositories;

import edu.vero.easyclass.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentJpaDao extends JpaRepository<Department,Integer> {

}
