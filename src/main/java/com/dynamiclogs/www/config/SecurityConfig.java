package com.dynamiclogs.www.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * 시큐리티 설정 클래스입니다.
 *
 * com.dynamiclogs.www.config
 * SecurityConfig.java
 *
 * @author : quickmenu
 * @date : 2016. 1. 24.
 * @version : 1.0
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin@dynamiclog.net").password("1234").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.headers().frameOptions().disable().and()
			.csrf().disable().anonymous()
		.and()
			.authorizeRequests()
			.antMatchers("/statics/**", "/signup", "/console/**")
			.permitAll()
			.anyRequest()
			.authenticated()
		.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/login/process")
			.defaultSuccessUrl("/")
			.permitAll()
		.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID");
	}
}
