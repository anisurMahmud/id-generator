package com.id.service;

import com.id.model.Department;
import com.id.model.Employee;
import com.id.model.Location;
import com.id.repository.DepartmentRepository;
import com.id.repository.EmployeeRepository;
import com.id.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final LocationRepository locationRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               DepartmentRepository departmentRepository,
                               LocationRepository locationRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public Employee save(String firstName, String surname, String locationCode, String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        Location location = locationRepository.findByLocationCode(locationCode);

        if(department == null){
            throw new RuntimeException("Department not found");
        }
        if(location == null){
            throw new RuntimeException("Location not found");
        }

        String baseId = firstName.charAt(0)+surname+location.getLocationCode()+department.getDepartmentCode();
        int uniqueNum = 1;
        while(employeeRepository.existsByCustomIdStartingWith(baseId+String.format("%03d",uniqueNum))){
            uniqueNum++;
        }
        String employeeId = baseId+String.format("%03d",uniqueNum);
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setSurname(surname);
        employee.setCustomId(employeeId);
        employee.setDepartment(department);
        employee.setLocation(location);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
