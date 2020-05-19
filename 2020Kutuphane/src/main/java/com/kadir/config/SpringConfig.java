package com.kadir.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.kadir")
@PropertySource("classpath:db.properties")
public class SpringConfig {

	@Autowired
	private Environment environment;
	
	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public DataSource loginDS() {
		ComboPooledDataSource loginDS = new ComboPooledDataSource();
		
		try {
			loginDS.setDriverClass(environment.getProperty("jdbc.driver"));
			
		} catch (PropertyVetoException e) {
			
			System.out.println("Driver not found");
		}
		
		
		
		loginDS.setJdbcUrl(environment.getProperty("jdbc.url"));
		loginDS.setUser(environment.getProperty("jdbc.user"));
		loginDS.setPassword(environment.getProperty("jdbc.password"));
		
		
		
		loginDS.setInitialPoolSize(Integer.parseInt(environment.getProperty("connection.pool.initialPoolSize")));
		loginDS.setMinPoolSize(Integer.parseInt(environment.getProperty("connection.pool.minPoolSize")));
		loginDS.setMaxPoolSize(Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize")));
		loginDS.setMaxIdleTime(Integer.parseInt(environment.getProperty("connection.pool.maxIdleTime")));
		
		return loginDS;
	}
	
	@SuppressWarnings("serial")
	Properties hibernateProperties() {
		return new Properties() {
			{
				setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));

				setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
			}
		};
	}
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(loginDS());
		sessionFactory.setPackagesToScan(new String[] { "com.kadir.domain" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	 @Bean
	  public HibernateTransactionManager getTransactionManager() {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	    transactionManager.setSessionFactory(sessionFactory().getObject());
	    return transactionManager;
	  }
	 
	   @Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	      return new PersistenceExceptionTranslationPostProcessor();
	   }
	
	

}
