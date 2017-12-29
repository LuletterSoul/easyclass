package edu.vero.easyclass.controllers;


import edu.vero.easyclass.domain.Department;
import edu.vero.easyclass.services.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(description = "院系业务")
@RestController
@RequestMapping(value = "/departments")
public class DepartmentController
{
    private DepartmentService departmentService;

    @Autowired
    public void setDepartmentService(DepartmentService departmentService)
    {
        this.departmentService = departmentService;
    }

    @ApiOperation(value = "查找全部的院系（测试通过）")
    @GetMapping(value = "")
    public ResponseEntity<List<Department>> findAllDepartments()
    {
        return new ResponseEntity<>(departmentService.findAllDepartments(), HttpStatus.OK);
    }

    @ApiOperation(value = "更新院系信息（测试通过）")
    @PutMapping(value = "")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department)
    {
        return new ResponseEntity<>(departmentService.updateDepartment(department), HttpStatus.OK);
    }

    @ApiOperation(value = "创建院系（测试通过）")
    @PostMapping(value = "")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department)
    {
        return new ResponseEntity<>(departmentService.createDepartment(department),
            HttpStatus.CREATED);
    }

    @ApiOperation(value = "根据id删除院系（测试通过）")
    @DeleteMapping(value = "/{depId}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable("depId") Integer depId)
    {
        return new ResponseEntity<>(departmentService.deleteDepartment(depId),
            HttpStatus.NO_CONTENT);
    }
}
