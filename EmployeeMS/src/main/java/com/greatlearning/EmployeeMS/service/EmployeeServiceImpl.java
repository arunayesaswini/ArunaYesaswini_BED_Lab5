package com.greatlearning.EmployeeMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeMS.model.Employee;
import com.greatlearning.EmployeeMS.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee e2) {

		return employeeRepository.save(e2);

	}

	public Employee getEmployee(int eid) {
		return employeeRepository.findById(eid).get();

	}

	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();
	}

	public void deleteEmployee(int eid) {

		employeeRepository.deleteById(eid);
	}

	public Employee updateEmployee(int eid, Employee e3) {

		Employee empdb = getEmployee(eid);
		empdb.setFirstname(e3.getFirstname());
		empdb.setLastname(e3.getLastname());
		empdb.setEmail(e3.getEmail());

		return employeeRepository.save(empdb);
	}

	

	

}
