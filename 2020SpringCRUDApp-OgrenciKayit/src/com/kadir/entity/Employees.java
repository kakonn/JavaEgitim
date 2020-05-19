package com.kadir.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "EMPLOYEES")
public class Employees {


	@Id
	@Column(name = "employee_id")
	@SequenceGenerator(name = "emp_seq", sequenceName = "employees_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
	private Integer employeeId;
	
	//@Pattern(regexp = "[A-Z]",message = "Kimin isminde sayi var ?")
	@NotEmpty
	@Column(name = "first_name")
	private String firstName;
	
//	@Pattern(regexp = "[A-Za-z]",message = "Kimin soyisminde sayi var ?")
	@NotEmpty
	@Column(name = "last_name")
	private String lastName;
	
	@NotEmpty(message = "Boþ gelme")
	@Email(message = "Bak orda email yaziyor, lütfen....")
	@Column(name = "email")
	private String email;

	@NotNull(message = "Boþ gelme")
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@NotNull
	@Column(name = "hire_date")
	private Date hireDate;
	
	@NotNull(message = "Boþ gelme")
	@Column(name = "salary")
	private Integer salary;
	
	@Column(name = "commission_pct")
	private Double commissionPercent;
	
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Employees manager;
	
	@NotNull(message = "Boþ gelme")
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	@ManyToOne
	@JoinColumn(name = "job_id")
	private Job job;

	public Double getCommissionPercent() {
		return commissionPercent;
	}

	public void setCommissionPercent(Double commissionPercent) {
		this.commissionPercent = commissionPercent;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Employees getManager() {
		return manager;
	}

	public void setManager(Employees manager) {
		this.manager = manager;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "manager = " + manager.getSalary() + "employee ="+getSalary() ;
	}

/*	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", salary=" + salary
				+ ", commissionPercent=" + commissionPercent + ", manager=" + manager + ", department=" + department.getDepartmentId()
				+ ", job=" + job.getJobId() + "]";
	}*/

	/*
	 * @Override public String toString() { return employeeId+firstName; }
	 */

}
