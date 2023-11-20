package com.moretolearn.curd.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Embeddable
@Data
public class EmployeePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "please provide id")
	@Column(name = "EMP_ID")
	private String empId;

	@Email(message = "please provide valid email")
	@Column(name = "EMP_EMIAL_ID")
	private String empEmailId;
}
