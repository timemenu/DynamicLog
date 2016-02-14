package com.dynamiclogs.www.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 
 * 시큐리티 설정 클래스입니다.
 *
 * @author : quickmenu
 * @date : 2016. 1. 24.
 * @version : 1.0
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery(getUserQuery())
			.authoritiesByUsernameQuery(getAuthoritiesQuery());
	}

	// 1. 유저관련 쿼리
	private String getUserQuery() {
		return "SELECT email AS username, password, TRUE AS enabled "
				+ "FROM USER " 
				+ "WHERE email = ?";
	}

	// 2. 권한관련 쿼리
	private String getAuthoritiesQuery() {
		return "SELECT email AS username, role "
				+ "FROM USER "
                + "WHERE email = ?";
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/statics/**", "/templates/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable()
			.and().csrf().disable().anonymous()
			.and()
				.authorizeRequests()
				.antMatchers("/signin", "/signup", "/console/**")
				.permitAll().anyRequest().authenticated()
			.and()
				.formLogin()
				.loginPage("/signin")
				.loginProcessingUrl("/login/process")
				.defaultSuccessUrl("/")
				.permitAll()
			.and()
				.logout()
				.logoutUrl("/signout")
				.logoutSuccessUrl("/signin")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID");
	}
}
