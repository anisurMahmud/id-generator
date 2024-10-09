package com.id.controller;

import com.id.model.Department;
import com.id.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/dept")
public class DepartmentController {

    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/")
    public @ResponseBody List<Department> allDepartments() {
        return departmentService.findAll();
    }

    @PostMapping(path = "/add")
    public @ResponseBody Department addDepartment(@RequestBody Department department) {
        return departmentService.save(department);
    }

}
