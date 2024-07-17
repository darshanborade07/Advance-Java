package com.sunbeam.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;
	@NotBlank(message = "User Name Must Not be Null!")
	private String uname;
	@NotBlank
	@Email(message = "Email Should be of Type Email!!")
	@Column(unique = true)
	private String email;
	@NotBlank
	@Length(min = 6, message = "Password Length should be at least 6 Characters!! ")
	private String password;
	@NotBlank(message = "City should not be Blank!!!")
	private String city;
	@NotBlank
	@Length(min = 10, message = "Contact no Length should be at least 10 Characters!! ")
	private String contactNo;
	private LocalDate birthDate;
}
