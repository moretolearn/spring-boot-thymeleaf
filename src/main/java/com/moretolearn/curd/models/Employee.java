package com.moretolearn.curd.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "PIPL_EMPLOYEE")
@Data
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@EmbeddedId
	private EmployeePK employeePK;
	
	@Size(min = 3,max = 30,message = "please enter valid name")
	@Column(name = "EMP_NAME")
	private String empName;
	
	@Pattern(regexp="(0/91)?[7-9][0-9]{9}",message="please enter valid number")
	@Column(name = "EMP_PHONE")
	private Integer empPhone;
	
	@NotBlank(message = "please enter value")
	@Column(name = "EMP_DESG")
	private String empDesg;
	
}
