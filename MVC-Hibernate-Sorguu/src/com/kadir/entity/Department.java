package com.kadir.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENTS")
public class Department {
	@Id
	@Column(name = "department_id")
	@SequenceGenerator(name = "dept_seq", sequenceName = "DEPARTMENTS_SEQ", allocationSize = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq")
	private Integer departmentId;

	/*
	 * @Id
	 * 
	 * @Column(name = "department_id")
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) private int departmentId;
	 */
	@Column(name = "department_name")
	private String departmentName;
	@Column(name = "manager_id")
	private Integer managerId;
	@Column(name = "location_id")
	private Integer locationId;

	public Department() {
		super();
	}

	public Department(String department_name, int managerId, int locationId) {
		super();
		this.departmentName = department_name;
		this.managerId = managerId;
		this.locationId = locationId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

}
