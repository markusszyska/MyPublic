package com.szyska.employeeAPI.data.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(path = "/getEmpById/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public Optional<Employee> getEmployeeById(@PathVariable Integer id) {
		
		return employeeRepo.findById(id);
	}
	

	@PostMapping(path="/addEmployee",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addEmployeeToDatabase(@RequestBody Employee employee) {
		try {
			this.employeeRepo.save(employee);
		}catch(Exception e){
			 
		}
	}
	
}
