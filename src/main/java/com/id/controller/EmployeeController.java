package com.id.controller;

import com.id.model.Employee;
import com.id.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path = "/add")
    public @ResponseBody Employee addEmployee(
            @RequestParam String firstName, @RequestParam String surname,
            @RequestParam String locationCode, @RequestParam String departmentCode) {
        return employeeService.save(firstName, surname, locationCode, departmentCode);
    }

    @GetMapping(path = "/")
    public @ResponseBody List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }


}
