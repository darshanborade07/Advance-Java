package com.sunbeam.DTO;


import com.sunbeam.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class SoldDetailsDTO {
	private String vname;
	private User user;
	
}
