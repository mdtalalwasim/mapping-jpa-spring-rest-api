package com.mdtalalwasim.springrestapi.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmployeeResponse {
	
	private Long id;
	
	private String employeeName;
	
	//private String departmentName;
	
	private List<String> departmentName;//for One to Many Bi-Directional

}
