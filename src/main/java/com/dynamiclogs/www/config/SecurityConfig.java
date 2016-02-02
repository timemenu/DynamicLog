package com.dynamiclogs.www.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUserDetailsService;

import com.dynamiclogs.www.config.social.SocialUsersDetailService;

/**
 * 
 * 시큐리티 설정 클래스입니다.
 * (TODO 작성필요)
 * https://github.com/brant-hwang/spring-boot-social-example/blob/master/src/main/java/com/axisj/examples/spring/social/SecurityConfig.java
 * https://github.com/callistaenterprise/blog-social-login-with-spring-social
 * 
 * com.dynamiclogs.www.config SecurityConfig.java
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
	
	@Autowired
	private UserDetailsService userDetailsService;

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
		web.ignoring().antMatchers("/resource/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable()
			.and().csrf().disable().anonymous()
			.and()
				.authorizeRequests()
				.antMatchers("/**", "/statics/**", "/signup", "/console/**")
				.permitAll().anyRequest().authenticated()
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
	
	@Bean
	public SocialUserDetailsService socialUsersDetailService() {
		return new SocialUsersDetailService(userDetailsService);
	}

	@Override
	protected UserDetailsService userDetailsService() {
		return userDetailsService;
	}
	
	
}
