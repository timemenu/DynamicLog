package com.dynamiclogs.www.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * H2 데이터베이스 콘솔
 *
 * com.bepcar.www.config
 * WebH2Configuration.java
 *
 * @author : quickmenu
 * @date : 2016. 1. 11.
 * @version : 1.0
 *
 */
@Configuration
public class WebH2Configuration {
	
	@Bean
	ServletRegistrationBean h2ServletRegistration() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}
}
