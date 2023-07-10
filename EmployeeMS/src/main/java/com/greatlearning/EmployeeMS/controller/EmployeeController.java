package com.greatlearning.EmployeeMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.EmployeeMS.model.Employee;
import com.greatlearning.EmployeeMS.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> listemployees = employeeService.getAllEmployees();
		theModel.addAttribute("employees", listemployees);
		return "employees/list-employees";
	}

	@GetMapping("/new")
	public String showFormForAdd(Model theModel) {
		Employee e1 = new Employee();
		theModel.addAttribute("employee", e1);
		return "employees/employee-form";
	}

	@PostMapping("/edit")
	public String edit(@RequestParam("employeeId") int eid, Model theModel) {
		// getting the book from the service
		Employee empdb = employeeService.getEmployee(eid);

		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("employee", empdb);

		// send over to the employee-form
		return "employees/update-form";

	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee semp) {
		employeeService.addEmployee(semp);
		return "redirect:/employee/list";
	}

	@PostMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int eid) {
		employeeService.deleteEmployee(eid);
		return "redirect:/employee/list";
	}

}
