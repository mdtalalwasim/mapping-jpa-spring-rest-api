
package com.mdtalalwasim.springrestapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdtalalwasim.springrestapi.entity.Employee;
import com.mdtalalwasim.springrestapi.repository.EmployeeRepository;
import com.mdtalalwasim.springrestapi.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		
		return employeeRepository.findAll();
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}


	@Override
	public Employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		}
		return null;
		
	}


	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}


	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> findByDepartmentName(String name) {
		return employeeRepository.findByDepartmentName(name);
	}


	@Override
	public List<Employee> getEmployeeByDepartment(String name) {
		// TODO Auto-generated method stub
		return employeeRepository.getEmployeeByDepartment(name);
	}




	
	
	

}
