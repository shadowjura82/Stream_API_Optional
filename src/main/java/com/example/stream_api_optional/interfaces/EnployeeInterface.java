package com.example.stream_api_optional.interfaces;

import com.example.stream_api_optional.model.Employee;

import java.util.List;

public interface EnployeeInterface {
    List<Employee> fillList();

    List<Employee> getEmployees();

    String employeesPrint();
}
