package com.kadir.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Aspect
@Component
@Order(5)
public class GetAspect {
	
	@Pointcut("execution (* get*(..))")
	private void getterPc() {
		
	}
	@Pointcut("execution (* *sim*(..))")
	public void simPc() {
		
	}
	
	@Before("simPc()")
	public void logMesaj3() {
		System.out.println("getter calisti");
		
	}
	
	
	@Pointcut("execution (* set*(..))")
	private void setterPc() {
		
	}
	
	@Before("setterPc()")
	public void logMesaj4(JoinPoint jp) {
		System.out.println("setter calisti");
		
		MethodSignature ms = (MethodSignature) jp.getSignature();
		
		Object[] args = jp.getArgs();
		System.out.println("Method" +ms.getMethod());
		System.out.println("Parametreler...");
		for (Object object : args) {
			System.out.println(object);
		}	
			
	}
	
	/*@Before("simPc()")
	public void logMesaj() {
		System.out.println("ikisi birden,logluyoruz");
		
	}*/
	
	/*@Before("execution(* get*(..))")
	public void beforeGet() {
		System.out.println("beforeGet");
	}*/
}
