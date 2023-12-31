package com.example.forage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.forage.Model.Employee;
import com.example.forage.Model.EmployeeManager;
import com.example.forage.Model.Employees;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
    private EmployeeManager employeeManager;

    public EmployeeController(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @GetMapping
    public Employees getAllEmployees() {
        return employeeManager.getEmployees();
    }
    
    @PostMapping
    public Employees addEmployee(@RequestBody Employee newEmployee) {
        Employees employees = employeeManager.getEmployees();
        employees.getEmployeeList().add(newEmployee);
        return employees;
    }
}
