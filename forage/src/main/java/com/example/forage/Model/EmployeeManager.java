package com.example.forage.Model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeManager {
	
    private Employees employees;

    public EmployeeManager() {
        initializeEmployees();
    }

    private void initializeEmployees() {
        // Hard-coded example employees
        List<Employee> exampleEmployees = new ArrayList<>();
        exampleEmployees.add(new Employee(1, "John", "Doe", "john.doe@email.com", "Developer"));
        exampleEmployees.add(new Employee(2, "Jane", "Smith", "jane.smith@email.com", "Designer"));
        exampleEmployees.add(new Employee(3, "Bob", "Johnson", "bob.johnson@email.com", "Manager"));

        employees = new Employees();
        employees.setEmployeeList(exampleEmployees);
    }

    public Employees getEmployees() {
        return employees;
    }
}
