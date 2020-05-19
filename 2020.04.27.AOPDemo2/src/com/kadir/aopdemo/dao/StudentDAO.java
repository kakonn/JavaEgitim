package com.kadir.aopdemo.dao;

import org.springframework.stereotype.Repository;

import com.kadir.aopdemo.domain.Student;

@Repository
public class StudentDAO {
	
	
	public void addStudent(Student s) {
		System.out.println("addStudent called");
		
	}
	
	public void addStudent(String s) {
		System.out.println("addStudent(String) called");
		
	}
	
	public void deleteStudent(Student s) {
		System.out.println("deleteStudent called");
		
	}
	
	public void queryStudent(Student name) {
		System.out.println("queryStudent called");
		
	}
	

}
