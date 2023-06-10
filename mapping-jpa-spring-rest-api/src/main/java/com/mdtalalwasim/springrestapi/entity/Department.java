package com.mdtalalwasim.springrestapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter 
@Getter
@ToString	
@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;  
	
	//To understand (Many to One)-Relationship 
	//Many to One -> Many Departments can belong to Single Employee / A Single Employee can have many departments. 
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	//Many to One -> Many Departments can belong to Single Employee. 
	
	
//	//for One to One Bi-Directional
//	@OneToOne(mappedBy = "department")
//	private Employee employee;
}
