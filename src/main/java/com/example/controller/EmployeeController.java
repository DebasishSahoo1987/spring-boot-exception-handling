package com.example.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.EmployeeNotFoundException;
import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> save(@RequestBody Employee emp){
		return new ResponseEntity<Employee>(employeeService.saveEmp(emp), HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<Employee>> fetchAll(){
		return new ResponseEntity<List<Employee>>(employeeService.fetchAll(),HttpStatus.OK);
	}
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<Employee> fetchById(@PathVariable int id) throws EmployeeNotFoundException{
		return new ResponseEntity<Employee>(employeeService.findById(id),HttpStatus.OK);
	}

}
