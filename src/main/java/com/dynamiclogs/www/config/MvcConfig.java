package com.dynamiclogs.www.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * 리소스 연결 관련 클래스파일입니다.
 *
 * com.dynamiclogs.www.config
 * StaticResourceConfiguration.java
 *
 * @author : quickmenu
 * @date : 2015. 12. 30.
 * @version : 1.0
 *
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/statics/");
	}
	
}
