package com.kadir.service;

import java.util.List;

import com.kadir.entity.Department;
import com.kadir.entity.Employees;
import com.kadir.entity.Job;

public interface EmployeeService {

	public Employees getEmployee(int employeeId);

	public List<Department> getDepartments();

	public List<Job> getJobs();

	public void saveOrUpdate(Employees employee);

	public List<Employees> findByManager(int id);

	public List<Employees> getEmployees();

	public void deleteEmployee(int employeeId);

	public List<Employees> getAraEmployee(Employees employee);

	

}
