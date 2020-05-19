package com.omer.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource loginDS;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(loginDS);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// login oldumu her kaynaga erisir
		/*
		 * http .authorizeRequests() .anyRequest() .authenticated();
		 */

		http.authorizeRequests().antMatchers("/").authenticated().antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/personel/**").hasAnyRole("PERSONEL", "ADMIN");
		// .antMatchers("/personel/**").hasRole("ADMIN");

		http.formLogin().loginPage("/loginForm").loginProcessingUrl("/authenticateTheUser").permitAll();

		http.logout().permitAll();

		http.exceptionHandling().accessDeniedPage("/access-denied");

	}

}
