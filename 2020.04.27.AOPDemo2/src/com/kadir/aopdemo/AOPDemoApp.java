package com.kadir.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kadir.aopdemo.domain.Student;

public class AOPDemoApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AOPDemoConfig.class);

		System.out.println("Context Started");

		// StudentDAO stDAO = ctx.getBean("studentDAO",StudentDAO.class);
		// stDAO.addStudent(new Student());
		Student stu = ctx.getBean("student", Student.class);
	/*	try {
			System.out.println(stu.getAdSoyad());
		} catch (Exception e) {
		//	e.printStackTrace();
		}*/
	/*	System.out.println("GET ID ...........");
		try {
			System.out.println(stu.getId());
		} catch (Exception e) {
			
		//	e.printStackTrace();
		}*/
		System.out.println("GET ISIM .........");
		System.out.println(stu.getIsim());
		ctx.close();
		System.out.println("Context Closed");

	}
}
