package com.example.stream_api_optional.service.impl;

import com.example.stream_api_optional.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.stream_api_optional.service.impl.EmployeeTestConstants.*;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    void shouldReturnDepartmentSalarySum() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(EMPLOYEES_TOTAL_SALARY, departmentService.getDepartmentSalarySum(DEPARTMENT_ID));
    }

    @Test
    void shouldReturnMaxSalaryEmployee() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY_EMPLOYEE, departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }

    @Test
    void shouldReturnMinSalaryEmployee() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY_EMPLOYEE, departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }

    @Test
    void shouldThrowEmployeeNotFoundExceptionWhenFindEmployeeWithMaxSalary() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }

    @Test
    void shouldThrowEmployeeNotFoundExceptionWhenFindEmployeeWithMinSalary() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }

    @Test
    void shouldReturnEmployeesByDepartmentId() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);
        assertEquals(EMPLOYEES, departmentService.findEmployeesByDepartment(DEPARTMENT_ID));
        assertEquals(singletonList(OTHER_DEPARTMENT_EMPLOYEE), departmentService.findEmployeesByDepartment(DEPARTMENT_ID2));
    }

    @Test
    void shouldReturnAllEmployees() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);
        assertEquals(EMPLOYEES_BY_DEPARTMENT_MAP, departmentService.findEmployeesByDepartment());
    }
}