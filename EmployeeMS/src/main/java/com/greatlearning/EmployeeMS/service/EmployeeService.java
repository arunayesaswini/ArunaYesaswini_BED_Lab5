package com.greatlearning.EmployeeMS.service;

import java.util.List;

import com.greatlearning.EmployeeMS.model.Employee;

public interface EmployeeService {
	Employee addEmployee(Employee e2);

	Employee getEmployee(int eid);

	List<Employee> getAllEmployees();

	void deleteEmployee(int eid);

	Employee updateEmployee(int eid, Employee e3);

}
