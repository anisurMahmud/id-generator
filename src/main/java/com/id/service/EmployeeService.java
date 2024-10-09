package com.id.service;

import com.id.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee save(String firstName, String surname, String locationCode, String departmentCode);
}
