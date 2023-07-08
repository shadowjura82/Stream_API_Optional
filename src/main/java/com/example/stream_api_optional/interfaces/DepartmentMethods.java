package com.example.stream_api_optional.interfaces;

import com.example.stream_api_optional.model.Employee;
import com.example.stream_api_optional.services.EmployeeInterfaceImpl;

import java.util.List;
import java.util.Map;

public interface DepartmentMethods {
    Employee maxSalary(int departmentId);

    Employee minSalary(int departmentId);

    List<Employee> listOfEmployees(int departmentId);

    Map<Integer, List<Employee>> listOfEmployeesGrouped();
}
