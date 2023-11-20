package com.moretolearn.curd.services;

import java.util.List;

import com.moretolearn.curd.models.Employee;
import com.moretolearn.curd.models.EmployeePK;

public interface IEmployeeService {

	public Employee addEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployee(EmployeePK employeePK);
	
	public Employee updateEmployee(Employee employee);
	
	public void deleteEmployee(EmployeePK employeePK);
	
	
}
