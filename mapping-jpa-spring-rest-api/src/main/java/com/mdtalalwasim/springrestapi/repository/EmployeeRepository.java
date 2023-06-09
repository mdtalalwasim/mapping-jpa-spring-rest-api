package com.mdtalalwasim.springrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mdtalalwasim.springrestapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	
	//Commented portion of code was implemented for (One To One) Relationship between Employee And Department
	
//	//implemented with JPA - finder method
//	List<Employee>findByDepartmentName(String name);
//	
//	
//	//JPQL - the same above method implemented in JPQL
//	@Query("FROM Employee WHERE department.name=:name")
//	List<Employee> getEmployeeByDepartment(String name);
	//Above, Commented portion of code was implemented for (One To One) Relationship between Employee And Department

}
