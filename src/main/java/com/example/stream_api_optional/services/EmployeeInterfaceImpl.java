package com.example.stream_api_optional.services;

import com.example.stream_api_optional.interfaces.EnployeeInterface;
import com.example.stream_api_optional.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeInterfaceImpl implements EnployeeInterface {
    private List<Employee> employees = new ArrayList<>();
    private static final String[] FIRST_NAMES = {"Петр", "Василий", "Николай", "Александр", "Тихон", "Сергей", "Владимир", "Игорь", "Данил", "Илья"};
    private static final String[] LAST_NAMES = {"Иванов", "Александров", "Таранов", "Прудняков", "Заречный", "Трофимов", "Пустовойт", "Астахов", "Калиниченко", "Конаненко"};

    @Override
    public List<Employee> fillList() {
        Random x = new Random();
        this.employees = Stream.generate(() -> new Employee(FIRST_NAMES[x.nextInt(10)], LAST_NAMES[x.nextInt(10)], x.nextInt(5), x.nextInt(100000)))
                .limit(50)
                .collect(Collectors.toList());
        return this.employees;
    }

    public List<Employee> getEmployees(){
        return employees;
    }

    public String employeesPrint(){
        return this.employees.stream().map(Employee::toString).collect(Collectors.joining());
    }
}
