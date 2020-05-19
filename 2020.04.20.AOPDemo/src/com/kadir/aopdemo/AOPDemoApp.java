package com.kadir.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kadir.aopdemo.dao.StudentDAO;
import com.kadir.aopdemo.domain.Student;

public class AOPDemoApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AOPDemoConfig.class);

		System.out.println("Context Started");

		// StudentDAO stDAO = ctx.getBean("studentDAO",StudentDAO.class);
		// stDAO.addStudent(new Student());
		Student stu = ctx.getBean("student", Student.class);
		System.out.println(stu.getIsim());
		System.out.println("------------------");
		stu.setIsim("Kadir");
		stu.setSoyisim("Kondur");
		System.out.println("----------------");
		System.out.println(stu.getAdSoyad());
		// System.out.println(stu.getSoyisim());
		// stu.getIsim();
		// stu.getSoyisim();
		System.out.println("----------------------------------");
		stu.afterSetStudent();
		System.out.println(stu.getIsim());
		ctx.close();
		System.out.println("Context Closed");

	}
}
