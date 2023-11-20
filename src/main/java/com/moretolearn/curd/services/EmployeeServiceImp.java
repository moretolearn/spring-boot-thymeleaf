package com.moretolearn.curd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moretolearn.curd.models.Employee;
import com.moretolearn.curd.models.EmployeePK;
import com.moretolearn.curd.repository.EmployeeReposiotory;

@Service
public class EmployeeServiceImp implements IEmployeeService {

	@Autowired
	EmployeeReposiotory empRep;

	@Override
	public Employee addEmployee(Employee employee) {
		Employee saveEmployee = empRep.save(employee);
		return saveEmployee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> findAll = empRep.findAll();
		return findAll;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee updateEmployee = empRep.save(employee);
		return updateEmployee;
	}

	@Override
	public Employee getEmployee(EmployeePK employeePK) {
		Optional<Employee> findById = empRep.findById(employeePK);
		return findById.get();
	}

	@Override
	public void deleteEmployee(EmployeePK employeePK) {
		empRep.deleteById(employeePK);
	}

}
