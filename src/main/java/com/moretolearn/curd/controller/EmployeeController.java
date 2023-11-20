package com.moretolearn.curd.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.moretolearn.curd.models.Employee;
import com.moretolearn.curd.models.EmployeePK;
import com.moretolearn.curd.services.EmployeeServiceImp;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeServiceImp employeeServiceImp;

	@RequestMapping("/")
	public String listOfEmployees(Model model) {
		List<Employee> allEmployees = employeeServiceImp.getAllEmployees();
		model.addAttribute("allEmployees", allEmployees);
		return "index";
	}

	@RequestMapping(path = "/newEmployee")
	public String addEmployees(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	@RequestMapping(path = "/saveEmployee", method = RequestMethod.POST)
	public String saveEmployees(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError objectError : allErrors) {
				System.err.println(objectError.toString());
			}
			return "new_employee";
		} else {
			Employee addEmployee = employeeServiceImp.addEmployee(employee);
			return "redirect:/";
		}
	}

	@RequestMapping(path = "/editEmployee/{empId}/{empEmailId}")
	public String editEmployees(@PathVariable("empId") String empId, @PathVariable("empEmailId") String empEmailId,
			Model model) {
		EmployeePK employeePK = new EmployeePK();
		employeePK.setEmpEmailId(empEmailId);
		employeePK.setEmpId(empId);
		Employee addEmployee = employeeServiceImp.getEmployee(employeePK);
		model.addAttribute("employee", addEmployee);
		return "update_employee";
	}

	@RequestMapping(path = "/updateEmployee", method = RequestMethod.POST)
	public String updateEmployees(@ModelAttribute("employee") Employee employee) {
		Employee addEmployee = employeeServiceImp.addEmployee(employee);
		return "redirect:/";
	}

	@RequestMapping(path = "/deleteEmployee/{empId}/{empEmailId}")
	public String deleteEmployees(@PathVariable("empId") String empId, @PathVariable("empEmailId") String empEmailId) {
		EmployeePK employeePK = new EmployeePK();
		employeePK.setEmpEmailId(empEmailId);
		employeePK.setEmpId(empId);
		employeeServiceImp.deleteEmployee(employeePK);
		return "redirect:/";
	}
}
