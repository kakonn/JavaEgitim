package com.kadir.aspect;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.kadir")
@EnableAspectJAutoProxy
public class AOPConfig {
	
}
