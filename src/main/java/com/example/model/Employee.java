package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	@Column(name="empId")
	@GeneratedValue
	private int id;
	
	@Column
	@Size(max=10,min=5,message="Name criteria not met. length must be 5 to 10 characters")
	private String empName;
	
	@NotNull(message = "Employee salary should not be null")
	@NotEmpty
	@NotBlank
	private String empSal;
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Pattern(regexp = "^\\d{10}$",message = "invalid mobile no")
	private String empMobile;
	
	@Email(message = "invalid Email id")
	private String email;

	public Employee() {
		super();
	}

	public Employee(int id, String empName, String empSal, String empMobile, String email) {
		super();
		this.id = id;
		this.empName = empName;
		this.empSal = empSal;
		this.empMobile = empMobile;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", empSal=" + empSal + ", empMobile=" + empMobile
				+ ", email=" + email + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpSal() {
		return empSal;
	}

	public void setEmpSal(String empSal) {
		this.empSal = empSal;
	}

	public String getEmpMobile() {
		return empMobile;
	}

	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
