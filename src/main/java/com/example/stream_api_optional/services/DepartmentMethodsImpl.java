package com.example.stream_api_optional.services;

import com.example.stream_api_optional.interfaces.DepartmentMethods;
import com.example.stream_api_optional.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentMethodsImpl implements DepartmentMethods {
    private final EmployeeInterfaceImpl employeeInterface;

    public DepartmentMethodsImpl(EmployeeInterfaceImpl employeeInterface) {
        this.employeeInterface = employeeInterface;
    }

    @Override
    public Employee maxSalary(int departmentId) {
        return employeeInterface.getEmployees().stream()
                .filter(e -> e.getDepartmentID() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Employee minSalary(int departmentId) {
        return employeeInterface.getEmployees().stream()
                .filter(e -> e.getDepartmentID() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public List<Employee> listOfEmployees(int departmentId) {
        return employeeInterface.getEmployees().stream()
                .filter(e -> e.getDepartmentID() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> listOfEmployeesGrouped() {
        return employeeInterface.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentID));
    }
}