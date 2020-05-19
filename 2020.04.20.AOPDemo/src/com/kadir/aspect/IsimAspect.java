package com.kadir.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Aspect
@Component
@Order(1)
public class IsimAspect {
	
	/*@Pointcut("execution (* get*(..))")
	private void getterPc() {
		
	}*/
	@Pointcut("execution (* *sim(..))")
	public void simPc() {
		
	}
	
	@Before("simPc()")
	public void logMesaj() {
		System.out.println("ikisini birden,logluyoruz /isim");
		
	}
	
	/*@Before("execution(* get*(..))")
	public void beforeGet() {
		System.out.println("beforeGet");
	}*/
}
