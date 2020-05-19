package com.kadir.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Aspect
@Component
@Order(100)
public class SoyIsimAspect {
	
	
	@Before("com.kadir.aspect.IsimAspect.simPc()")
	public void logMesaj2() {
		System.out.println("isim aspect ile birlikte calisti");
		
	}
	
}
