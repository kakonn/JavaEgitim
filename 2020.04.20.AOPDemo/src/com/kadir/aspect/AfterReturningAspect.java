package com.kadir.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.kadir.aopdemo.domain.Student;

@Aspect
@Component
public class AfterReturningAspect {

	@Pointcut("execution (* getAdSoyad())")
	private void getAdSoyadPC() {

	}
	
	//nesne tanýmlarsak dönen deðere müdahele edebiliriz
	@AfterReturning(pointcut = "getAdSoyadPC()", returning = "result")
	public void adSoyadIzle(JoinPoint jp, String result) {
		System.out.println("getAdSoyad calisti");
		System.out.println(jp.getSignature());
		System.out.println("Sonuc: " + result);
	}
	@Pointcut("execution (* afterSetStudent())")
	private void afterSetStudent() {

	}
	@AfterReturning(pointcut = "afterSetStudent()", returning = "result")
	public void setIzle(JoinPoint jp, Student result) {
		System.out.println("after set Studenttt");
		result.setIsim("Kadir2");
	}

}
