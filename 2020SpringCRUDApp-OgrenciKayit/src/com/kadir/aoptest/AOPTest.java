package com.kadir.aoptest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kadir.aspect.AOPConfig;
import com.kadir.service.EmployeeService;




public class AOPTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);
		
		
		
		//EmployeeServiceImpl emp = ctx.getBean("employee",EmployeeServiceImpl.class);
		EmployeeService emp = ctx.getBean("employee",EmployeeService.class);
	
	//	emp.getEmployees();
	}
}
