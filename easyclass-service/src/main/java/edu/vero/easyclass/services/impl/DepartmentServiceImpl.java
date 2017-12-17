package edu.vero.easyclass.services.impl;


import edu.vero.easyclass.repositories.DepartmentJpaDao;
import edu.vero.easyclass.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartmentServiceImpl implements DepartmentService
{

    private DepartmentJpaDao departmentJpaDao;

    @Autowired
    public void setDepartmentJpaDao(DepartmentJpaDao departmentJpaDao)
    {
        this.departmentJpaDao = departmentJpaDao;
    }
}
