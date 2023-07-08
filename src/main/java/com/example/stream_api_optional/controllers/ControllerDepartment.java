package com.example.stream_api_optional.controllers;

import com.example.stream_api_optional.model.Employee;
import com.example.stream_api_optional.services.DepartmentMethodsImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class ControllerDepartment {
    private final DepartmentMethodsImpl departmentMethods;

    public ControllerDepartment(DepartmentMethodsImpl departmentMethods) {
        this.departmentMethods = departmentMethods;
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalary(@RequestParam("departmentId") int departmentId) {
        return departmentMethods.maxSalary(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam("departmentId") int departmentId) {
        return departmentMethods.minSalary(departmentId);
    }

    @GetMapping(path = "/all")
    public List<Employee> listOfEmployees(@RequestParam("departmentId") int departmentId) {
        return departmentMethods.listOfEmployees(departmentId);
    }

    @GetMapping(path = "/allGrouped")
    public Map<Integer, List<Employee>> listOfEmployeesGrouped() {
        return departmentMethods.listOfEmployeesGrouped();
    }
}