package com.szyska.employeeAPI.data.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@GetMapping(path="/getAllEmployees", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addEmployeeToDatabase(@RequestBody Employee employee) {
		try {
			this.employeeRepo.save(employee);
		}catch(Exception e){
			 
		}
	}
	
}
