package com.dynamiclogs.www.initializer;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import com.dynamiclogs.www.Application;

/**
 * 
 * 외부 톰켓 연동(서블릿, BOOT실행 연결)
 *
 * com.dynamiclogs.www.config
 * ServletInitializer.java
 *
 * @author : quickmenu
 * @date : 2016. 1. 19.
 * @version : 1.0
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}
	
}
