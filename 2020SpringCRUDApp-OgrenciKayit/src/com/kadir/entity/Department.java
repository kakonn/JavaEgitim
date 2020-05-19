package com.kadir.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENTS")
public class Department {
	
	@Id
	@Column(name = "department_id")
	@SequenceGenerator(name = "dep_seq", sequenceName = "departments_seq", allocationSize = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dep_seq")
	private Integer departmentId;
	
	@Column(name = "department_name")
	private String departmentName;
	
	@Column(name = "location_id")
	private Integer locationId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "manager_id")
	private Employees manager;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "department")
	private List<Employees> deptEmployees;

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

	public Employees getManager() {
		return manager;
	}

	public void setManager(Employees manager) {
		this.manager = manager;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public List<Employees> getDeptEmployees() {
		return deptEmployees;
	}

	public void setDeptEmployees(List<Employees> deptEmployees) {
		this.deptEmployees = deptEmployees;
	}

	@Override
	public String toString() {
		return departmentName;
	}
	
	
}
