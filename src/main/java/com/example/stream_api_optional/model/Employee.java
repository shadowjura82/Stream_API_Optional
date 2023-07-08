package com.example.stream_api_optional.model;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private int departmentID;
    private int salary;
    private int id;
    private static int count = 0;

    public Employee(String firstName, String lastName, int departmentID, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentID = departmentID;
        this.salary = salary;
        this.id = count;
        count++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return departmentID == employee.departmentID && salary == employee.salary && id == employee.id && firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departmentID, salary, id);
    }

    @Override
    public String toString() {
        return "Сотрудник: " + firstName + " " + lastName + ", Отдел: " + departmentID + ", Зарплата: " + salary + "\n";
    }
}
