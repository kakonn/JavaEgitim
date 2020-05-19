package com.kadir.SampleJson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//alan bilinmiyorsa ugrasma calıs
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

	private String firstName;
	private String lastName;
	private int salary;

	
	public String getFirstName() {
		return firstName;
	}

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		System.out.println("setFirstName");
	}

		public String getLastName() {
		return lastName;
	}

	
	public void setLastName(String lastName) {
		this.lastName = lastName;
		System.out.println("setLastName");
	}

	
	public int getSalary() {
		return salary;
	}

	
	public void setSalary(int salary) {
		this.salary = salary;
		System.out.println("setSalary");
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + "]";
	}

	public Employee() {
		super();
	}
	
	
}
