package com.example.stream_api_optional.service.impl;

import com.example.stream_api_optional.exception.EmployeeAlreadyAddedException;
import com.example.stream_api_optional.exception.EmployeeNotFoundException;
import com.example.stream_api_optional.model.Employee;
import com.example.stream_api_optional.service.EmployeeValidationService;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.capitalize;

@Service
public class EmployeeServiceImpl implements com.example.stream_api_optional.service.EmployeeService {
    private final Map<String, Employee> employees;
    private final EmployeeValidationService employeeValidationService;

    public EmployeeServiceImpl(EmployeeValidationService employeeValidationService) {
        this.employeeValidationService = employeeValidationService;
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int departmentId) {
        employeeValidationService.validate(firstName, lastName);
        return addEmployee(new Employee(capitalize(firstName), capitalize(lastName), salary, departmentId));
    }

    @Override
    public Employee add(String firstName, String lastName) {
        employeeValidationService.validate(firstName, lastName);
        return addEmployee(new Employee(capitalize(firstName), capitalize(lastName)));
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = find(firstName, lastName);
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        String fullNameKey = firstName + " " + lastName;
        if (!employees.containsKey(fullNameKey)) throw new EmployeeNotFoundException();
        return employees.get(fullNameKey);
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }

    private Employee addEmployee(Employee employee) {
        if (employees.containsKey(employee.getFullName())) throw new EmployeeAlreadyAddedException();
        employees.put(employee.getFullName(), employee);
        return employee;
    }
}