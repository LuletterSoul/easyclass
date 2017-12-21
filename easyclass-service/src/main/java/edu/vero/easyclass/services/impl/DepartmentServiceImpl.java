package edu.vero.easyclass.services.impl;

import edu.vero.easyclass.domain.Department;
import edu.vero.easyclass.repositories.DepartmentJpaDao;
import edu.vero.easyclass.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentJpaDao departmentJpaDao;

    @Autowired
    public void setDepartmentJpaDao(DepartmentJpaDao departmentJpaDao) {
        this.departmentJpaDao = departmentJpaDao;
    }

    @Override
    public List<Department> findAllDepartments() {
        return departmentJpaDao.findAll();
    }

    @Override
    public Department deleteDepartment(Integer depId) {
        Department department =departmentJpaDao.findOne(depId);
        departmentJpaDao.delete(department);
        return department;
    }

    @Override
    public Department createDepartment(Department department) {
        departmentJpaDao.saveAndFlush(department);
        return department;
    }

    @Override
    public Department updateDepartment(Department department) {
        departmentJpaDao.saveAndFlush(department);
        return department;
    }
}
