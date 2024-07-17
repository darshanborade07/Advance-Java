package com.sunbeam.DTO;

import com.sunbeam.entities.Company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VehicleResDTO {
	private String vname;
	private Company company;
	private String vnumber;
	private String vtype;
}
