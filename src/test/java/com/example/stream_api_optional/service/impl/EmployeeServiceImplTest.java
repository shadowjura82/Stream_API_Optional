package com.example.stream_api_optional.service.impl;

import com.example.stream_api_optional.exception.EmployeeAlreadyAddedException;
import com.example.stream_api_optional.exception.EmployeeNotFoundException;
import com.example.stream_api_optional.model.Employee;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static com.example.stream_api_optional.service.impl.EmployeeTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl(new EmployeeValidationServiceImpl());

    @Test
    void shouldAddEmployee() {
        Employee employee = new Employee(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        assertFalse(employeeService.findAll().contains(employee));
        Employee addedEmployee = employeeService.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        assertEquals(addedEmployee, employee);
        assertTrue(employeeService.findAll().contains(employee));
        assertEquals(1, employeeService.findAll().size());
    }

    @Test
    void shouldThrowEmployeeAlreadyAddedException() {
        Employee addedEmployee = employeeService.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        assertTrue(employeeService.findAll().contains(addedEmployee));
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID));
    }

    @Test
    void shouldRemoveEmployee() {
        Employee addedEmployee = employeeService.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        assertTrue(employeeService.findAll().contains(addedEmployee));
        assertEquals(1, employeeService.findAll().size());
        Employee removedEmployee = employeeService.remove(FIRST_NAME, LAST_NAME);
        assertEquals(addedEmployee, removedEmployee);
        assertFalse(employeeService.findAll().contains(addedEmployee));
        assertEquals(0, employeeService.findAll().size());
    }

    @Test
    void shouldThrowEmployeeNotFoundExceptionWhenRemoveEmployee() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.remove(FIRST_NAME, LAST_NAME));
    }

    @Test
    void shouldFindEmployee() {
        Employee addedEmployee = employeeService.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        assertEquals(addedEmployee, employeeService.find(FIRST_NAME, LAST_NAME));
    }

    @Test
    void shouldThrowEmployeeNotFoundExceptionWhenFindEmployee() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.find(FIRST_NAME, LAST_NAME));
    }

    @Test
    void shouldFindAllEmployees() {
        Employee addedEmployee1 = employeeService.add(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        Employee addedEmployee2 = employeeService.add(FIRST_NAME2, LAST_NAME2, SALARY, DEPARTMENT_ID);
        assertIterableEquals(List.of(addedEmployee1, addedEmployee2), employeeService.findAll());
    }
}