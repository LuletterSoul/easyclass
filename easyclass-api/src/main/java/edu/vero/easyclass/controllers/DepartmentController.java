package edu.vero.easyclass.controllers;

import edu.vero.easyclass.domain.Department;
import edu.vero.easyclass.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/arrangements")
public class DepartmentController {
    private DepartmentService departmentService;

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }



    @GetMapping(value = "")
    public ResponseEntity<List<Department>> findAllDepartments(){
        return null;
    }
}
