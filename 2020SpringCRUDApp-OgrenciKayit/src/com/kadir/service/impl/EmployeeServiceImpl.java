package com.kadir.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadir.dao.EmployeeDAO;
import com.kadir.entity.Department;
import com.kadir.entity.Employees;
import com.kadir.entity.Job;
import com.kadir.service.EmployeeService;

@Component
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	@Transactional
	@Override
	public List<Employees> getEmployees() {

		return employeeDAO.getOgrenciler();
	}

	@Transactional
	@Override
	public List<Department> getDepartments() {

		return employeeDAO.getDepartments();
	}

	@Transactional
	@Override
	public List<Job> getJobs() {

		return employeeDAO.getJobs();
	}
	
	@Transactional
	@Override
	public void saveOrUpdate(Employees employee) {
		employeeDAO.saveOrUpdate(employee);
		
	}
	
	@Transactional
	@Override
	public List<Employees> findByManager(int id) {
		
		return employeeDAO.findByManager(id);
	}
	
	@Transactional
	@Override
	public Employees getEmployee(int employeeId) {
		
		return employeeDAO.getEmployee(employeeId);
	}
	
	@Transactional
	@Override
	public void deleteEmployee(int employeeId) {
		employeeDAO.deleteEmployee(employeeId);
		
	}
	
	@Transactional
	@Override
	public List<Employees> getAraEmployee(Employees employee) {
		
		return employeeDAO.getAraEmployee(employee);
	}

}
