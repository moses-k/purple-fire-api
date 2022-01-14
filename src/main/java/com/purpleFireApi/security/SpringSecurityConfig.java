package com.purpleFireApi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Admin").password("admin").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("Mohamed,").password("user").roles("USER");
		auth.inMemoryAuthentication().withUser("John").password("user").roles("USER");
		auth.inMemoryAuthentication().withUser("Kumar").password("user").roles("USER");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/api/users")
				.hasAnyRole("ADMIN")
				.anyRequest()
				.fullyAuthenticated()
				.and()
				.httpBasic()
				.and()
				.sessionManagement()
				.invalidSessionUrl("/login?invalid-session=true	");
	}

	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

}