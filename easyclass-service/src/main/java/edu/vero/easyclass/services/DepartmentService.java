package edu.vero.easyclass.services;


import edu.vero.easyclass.domain.Department;

import java.util.List;


public interface DepartmentService
{

    public List<Department> findAllDepartments();

    Department deleteDepartment(Integer depId);

    Department createDepartment(Department department);

    Department updateDepartment(Department department);
}
