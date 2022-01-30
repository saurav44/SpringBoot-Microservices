package com.learningmicroservice.department.controller;

import com.learningmicroservice.department.entity.Department;
import com.learningmicroservice.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j                                  // for logging
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside saveDepartment method of DepartmentController.");
        return departmentService.saveDepartment(department);
    }

    @GetMapping(path = "/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("Inside findDepartmentById method of DepartmentController.");
        return departmentService.findDepartmentById(departmentId);
    }


}
