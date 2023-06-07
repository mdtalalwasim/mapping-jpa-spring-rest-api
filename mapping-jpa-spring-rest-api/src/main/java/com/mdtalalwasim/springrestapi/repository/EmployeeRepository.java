package com.mdtalalwasim.springrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdtalalwasim.springrestapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
