
package com.mdtalalwasim.springrestapi.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdtalalwasim.springrestapi.entity.Department;
import com.mdtalalwasim.springrestapi.entity.Employee;
import com.mdtalalwasim.springrestapi.repository.DepartmentRepository;
import com.mdtalalwasim.springrestapi.request.EmployeeRequest;
import com.mdtalalwasim.springrestapi.response.EmployeeResponse;
import com.mdtalalwasim.springrestapi.service.EmployeeService;



@RestController
//@RequestMapping("/api")--this will define in properties file
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DepartmentRepository departmentRepo;
	

	
	
	@GetMapping("/employees") 
	//public ResponseEntity<List<Employee>>  getEmployees() {
	public ResponseEntity<List<EmployeeResponse>>  getEmployees() {
		
		List<Employee> listOfEmployee = employeeService.getAllEmployees();
		
		List<EmployeeResponse> employeeResponseList = new ArrayList<>();
		
		listOfEmployee.forEach(e->{
			EmployeeResponse empRes = new EmployeeResponse();
			
			empRes.setId(e.getId());
			empRes.setEmployeeName(e.getName());
			
			List<String> deptsList = new ArrayList<>();
			for (Department dept : e.getDepartments()) {
				deptsList.add(dept.getName());
			}
			empRes.setDepartmentName(deptsList);
			employeeResponseList.add(empRes);
			
		});
		 
		return new ResponseEntity<List<EmployeeResponse>>(employeeResponseList, HttpStatus.OK);
		
//		//the below code
//		System.out.println("Fetching List of Employees..."); 
//		return new ResponseEntity<List<Employee>> (employeeService.getEmployees(), HttpStatus.OK);
	}
	
	@PostMapping("/employees")
	//public ResponseEntity<Employee>  saveEmployee(@RequestBody EmployeeRequest empRequest) {
	public ResponseEntity<String>  saveEmployee(@RequestBody EmployeeRequest empRequest) {
		

//		//the below commented portion of code for one to one relation between Employee and Department.
//		Department dept = new Department();
//		dept.setName(empRequest.getDepartment());
//		
//		Department deptObj = departmentRepo.save(dept);
//		
//		Employee emp = new Employee(empRequest);
//		emp.setDepartment(deptObj);
//		
//		Employee empObj = employeeService.saveEmployee(emp);
//		
//		
//		
//		System.out.println("Save new Employee...");
//		return new ResponseEntity<Employee> (empObj, HttpStatus.CREATED);
//		
//		//the commented portion of code for (One to One) relation between Employee and Department.
		
		
		//the below code for (Many To One) Mapping--> Many Department Single Employee....
		Employee employee = new Employee(empRequest);
		employee = employeeService.saveEmployee(employee);
			
		for (String s : empRequest.getDepartment()) {
			Department dept = new Department();
			
			dept.setName(s);
			dept.setEmployee(employee);
			
			departmentRepo.save(dept);
			 //System.out.println("dept--> save --> "+dept);

		}
		return new ResponseEntity<String>("Record save successfully!",HttpStatus.CREATED);
		//the above code for (Many To One) Mapping--> Many Department Single Employee....
		
	}


	// localhost:9090/employees/12 
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable() Long id) {
		System.out.println("Fetching Single Employee...");
		return new ResponseEntity<Employee>(employeeService.getEmployee(id), HttpStatus.OK);
	}
	
	
	//localhost:9090/employees/12
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		employee.setId(id);
		System.out.println("Updating Employee...");
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee), HttpStatus.OK); 
	}
	

	
	//localhost:9090/employees?id=12 
	@DeleteMapping("/employees")
	public ResponseEntity<HttpStatus> deleteEmployees(@RequestParam Long id) {
		System.out.println("Deleting Employee...");
		employeeService.deleteEmployee(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	 
//	//Commented portion of code was implemented for (One To One) Relationship between Employee And Department
//	@GetMapping("/employeesByDepartment") 
//	public ResponseEntity<List<Employee>> getEmployeeByDepartment(@RequestParam String name) {
//		
//		//return new ResponseEntity<List<Employee>>(employeeService.findByDepartmentName(name), HttpStatus.OK);//implemented in JPA-Finder-Method
//		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByDepartment(name), HttpStatus.OK);//implemented in JPQL
//	}
//	//Commented portion of code was implemented for (One To One) Relationship between Employee And Department


}
