package com.blogs.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

//fname, lname, phoneNo, dob
@Getter
@Setter
public class UserRespDTO extends BaseDTO{
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String phoneNo;
	//matching required from entity to dto for strict mapping
}
