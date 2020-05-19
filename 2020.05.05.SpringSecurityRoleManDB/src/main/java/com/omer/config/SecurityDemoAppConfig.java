package com.omer.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.omer")
@PropertySource("classpath:db.properties")
public class SecurityDemoAppConfig {
	
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public DataSource loginDS() {
		ComboPooledDataSource loginDS = new ComboPooledDataSource();
		
		try {
			loginDS.setDriverClass(env.getProperty("jdbc.driver"));
			logger.info("--> Driver bulundu");
		} catch (PropertyVetoException e) {
			logger.info("--> Driver bulunamadý");
			System.out.println("Driver not found");
		}
		
		logger.info("--> Setting url,user,pwd");
		
		loginDS.setJdbcUrl(env.getProperty("jdbc.url"));
		loginDS.setUser(env.getProperty("jdbc.user"));
		loginDS.setPassword(env.getProperty("jdbc.password"));
		
		logger.info("--> Setting pool properties");
		
		loginDS.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
		loginDS.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
		loginDS.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
		loginDS.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));
		
		return loginDS;
	}
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}

}
