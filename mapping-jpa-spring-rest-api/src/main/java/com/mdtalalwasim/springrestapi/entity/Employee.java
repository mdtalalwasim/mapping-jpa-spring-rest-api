package com.mdtalalwasim.springrestapi.entity;

import com.mdtalalwasim.springrestapi.request.EmployeeRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter 
@Getter
@ToString	
@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@JoinColumn(name = "department_id")
	@OneToOne 
	private Department department;

	public Employee(EmployeeRequest request) {
		this.name = request.getName();
	}
	
	
	
	
	
	

}
