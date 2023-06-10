package com.mdtalalwasim.springrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdtalalwasim.springrestapi.entity.Department;
import com.mdtalalwasim.springrestapi.entity.Employee;
import com.mdtalalwasim.springrestapi.repository.DepartmentRepository;
import com.mdtalalwasim.springrestapi.response.DepartmentResponse;
import com.mdtalalwasim.springrestapi.response.EmployeeResponse;
import com.mdtalalwasim.springrestapi.service.DepartmentService;
import com.mdtalalwasim.springrestapi.service.EmployeeService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private EmployeeService employeeService;
	
	
	
	@GetMapping("/departments")
	public List<DepartmentResponse> getDeaprtments(){
		
		List<Department> listOfDepts = departmentService.getAllDepartment();
		
		List<Employee> listOfEmployee = employeeService.getAllEmployees();
		
		List<DepartmentResponse> listOfDeptsResponse = new ArrayList<>();
		
		//List<DepartmentResponse> listOfEmpResponse = new ArrayList<>();
		
		listOfDepts.forEach(d->{
			DepartmentResponse dResponse = new DepartmentResponse();
			EmployeeResponse empResponse = new EmployeeResponse();
			
			dResponse.setDepartmentName(d.getName());
			dResponse.setId(d.getId());
			dResponse.setEmployeeName(d.getEmployee().getName());
			
			
			System.out.println("Department Response... ->"+dResponse);
			listOfDeptsResponse.add(dResponse);
		});
		
		System.out.println("Return --- Department Response... ->"+listOfDeptsResponse);
		return listOfDeptsResponse;
	}
}
