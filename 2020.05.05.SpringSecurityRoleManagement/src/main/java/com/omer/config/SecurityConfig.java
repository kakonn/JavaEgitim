package com.omer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@SuppressWarnings("deprecation")
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication().withUser(users.username("omer").password("omer").roles("ADMIN"))
				.withUser(users.username("ali").password("can").roles("PERSONEL"))
				.withUser(users.username("okan").password("yilmaz").roles("PERSONEL"));

		// TODO Auto-generated method stub
		// super.configure(auth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//login oldumu her kaynaga erisir
		/*
		 * http .authorizeRequests() .anyRequest() .authenticated();
		 */
		
		http
		.authorizeRequests()
		.antMatchers("/").authenticated()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/personel/**").hasAnyRole("PERSONEL","ADMIN");
	//	.antMatchers("/personel/**").hasRole("ADMIN");
		
		http
		.formLogin()
		.loginPage("/loginForm")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll();

		http.logout().permitAll();
		
		http.exceptionHandling().accessDeniedPage("/access-denied");

	}

}
