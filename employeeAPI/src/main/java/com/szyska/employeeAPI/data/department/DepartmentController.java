package com.szyska.employeeAPI.data.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DepartmentController {
	@Autowired
	DepartmentRepository departmentRepo;
	
	
}
