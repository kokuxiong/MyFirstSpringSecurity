package com.koku.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/vip1").hasAnyRole("VIP1","VIP2","VIP3")
				.antMatchers("/vip2").hasAnyRole("VIP2","VIP3")
				.antMatchers("/vip3").hasAnyRole("VIP3")
				.anyRequest()
				.authenticated()
				.and()
			.formLogin()
				.and()
			.logout()
				.clearAuthentication(true)
				.logoutSuccessUrl("/index");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**","/js/**","/image/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
			.withUser("koku").password(new BCryptPasswordEncoder().encode("123")).roles("VIP1","VIP2")
			.and()
			.withUser("admin").password(new BCryptPasswordEncoder().encode("123")).roles("VIP1","VIP2","VIP3")
			.and()
			.withUser("demo").password(new BCryptPasswordEncoder().encode("123")).roles("VIP1");
		
	}
	
}
