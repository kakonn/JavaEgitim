package com.kadir.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAspect {

	@Pointcut("execution (* get*(..))")
	private void getterPC() {

	}

	@Around("getterPC()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {

		//System.out.println(pjp.getSignature());
		System.out.println("Before...");
		long begin = System.currentTimeMillis();
		
		Object result = pjp.proceed();
		
		long end = System.currentTimeMillis();
		long sure = end-begin;
		System.out.println("After...");
		System.out.println("Program " + sure + " ms surdu");
		return result;
	}

}
