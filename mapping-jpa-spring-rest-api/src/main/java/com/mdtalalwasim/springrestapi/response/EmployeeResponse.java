package com.mdtalalwasim.springrestapi.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmployeeResponse {
	
	private Long id;
	
	private String employeeName;
	
	private String departmentName;

}
