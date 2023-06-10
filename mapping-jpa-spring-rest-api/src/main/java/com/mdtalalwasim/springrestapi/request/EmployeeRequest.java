package com.mdtalalwasim.springrestapi.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmployeeRequest{
	
	private String name;
	
	private String department; //for One to One Mapping
	
	//private List<String> department;//for Many to One Mapping
	
	
}
