package com.kadir.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
@Component
public class ErrorAspect {
	
	@Pointcut("execution (* get*(..))")
	private void getterPC() {
		
	}
	
	@After("getterPC()")
	public void after() {
		System.out.println("after finally");
	}
	
	//basarili donus
	@AfterReturning("getterPC()")
	public void afterReturning(JoinPoint jp) {
		System.out.println("after returning. " + jp.getSignature());
	}
	
	//hata
	@AfterThrowing(throwing = "exc", pointcut = "getterPC()")
	public void logError(JoinPoint jp, Throwable exc) {
		System.out.println("after throwing");
		System.out.println("Olay mahali : " + jp.getSignature());
		System.out.println("Hatasiz kod olmazz..."+exc);
		
	}
	
	
	
}
