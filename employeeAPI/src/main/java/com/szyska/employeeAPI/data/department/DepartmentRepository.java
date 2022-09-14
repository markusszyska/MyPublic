package com.szyska.employeeAPI.data.department;

import org.springframework.data.jpa.repository.JpaRepository;

import com.szyska.employeeAPI.data.employee.Employee;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
