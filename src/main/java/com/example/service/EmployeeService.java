package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.EmployeeNotFoundException;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	

	public Employee saveEmp(Employee employee){
		
		Employee emp = employeeRepository.save(employee);
		return emp;
		
	}
	
	public List<Employee> fetchAll(){
		List<Employee> empList=employeeRepository.findAll();
		return empList;
	}
	
	public Employee findById(int id) throws EmployeeNotFoundException {
		Optional<Employee> empList=employeeRepository.findById(id);
		if(empList.isPresent())
			return empList.get();
		else
			throw new EmployeeNotFoundException("Employee Information is not found for EmpID = "+id);
	}
	
	
	

}
