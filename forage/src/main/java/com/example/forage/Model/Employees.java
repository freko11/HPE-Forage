package com.example.forage.Model;

import java.util.List;

public class Employees {

	private List<Employee> employeeList;

	public Employees() {
		super();
	}
	
	

	public Employees(List<Employee> employeeList) {
		super();
		this.employeeList = employeeList;
	}



	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	
}
