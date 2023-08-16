package com.example.stream_api_optional.controller;

import com.example.stream_api_optional.model.Employee;
import com.example.stream_api_optional.service.impl.EmployeeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping("/add")
    public ResponseEntity<Employee> add(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = employeeServiceImpl.add(firstName, lastName);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/add-full")
    public ResponseEntity<Employee> add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer salary, @RequestParam Integer departmentId) {
        Employee employee = employeeServiceImpl.add(firstName, lastName, salary, departmentId);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/remove")
    public ResponseEntity<Employee> remove(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = employeeServiceImpl.remove(firstName, lastName);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/find")
    public ResponseEntity<Employee> find(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = employeeServiceImpl.find(firstName, lastName);
        return ResponseEntity.ok(employee);
    }

    @GetMapping
    public ResponseEntity<Collection<Employee>> findAll() {
        Collection<Employee> employees = employeeServiceImpl.findAll();
        return ResponseEntity.ok(employees);
    }


//    @GetMapping(path = "/add")
//    public List<Employee> generateEmployeeBase() {
//        return employeeService.fillList();
//    }
//
//    @GetMapping(path = "/print")
//    public String employeesPrint(){
//        return employeeService.employeesPrint();
//    }
}
