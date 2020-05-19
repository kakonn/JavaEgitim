package com.kadir.config;

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

		auth.inMemoryAuthentication().withUser(users.username("kadir").password("123").roles("ADMIN"))
				.withUser(users.username("ali").password("can").roles("PERSONEL"))
				.withUser(users.username("okan").password("yilmaz").roles("PERSONEL"));

		// super.configure(auth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// butun istekler kimlik dogrulamasindan gececek
		http
		 .authorizeRequests()
		 	.anyRequest()
		 	.authenticated();

		http
		 .formLogin()
		 	.loginPage("/loginForm")
		 	.loginProcessingUrl("/autenticateTheUser")
		 	.permitAll();
	
		http.logout().permitAll();
		
	}
	
}
