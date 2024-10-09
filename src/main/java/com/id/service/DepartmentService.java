package com.id.service;

import com.id.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();

    Department save(Department department);
}
