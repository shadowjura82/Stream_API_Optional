package com.example.stream_api_optional.controllers;

import com.example.stream_api_optional.model.Employee;
import com.example.stream_api_optional.services.EmployeeInterfaceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@RestController
public class ControllerEmployee {
    private final EmployeeInterfaceImpl employeeInterface;

    public ControllerEmployee(EmployeeInterfaceImpl employeeInterface) {
        this.employeeInterface = employeeInterface;
    }

    @GetMapping(path = "/generate") // этот метод используется чтоб случайным образом заполнить лист сотрудников
    public List<Employee> generateEmployeeBase() {
        return employeeInterface.fillList();
    }

    @GetMapping(path = "/print")
    public String employeesPrint(){
        return employeeInterface.employeesPrint();
    }


}
