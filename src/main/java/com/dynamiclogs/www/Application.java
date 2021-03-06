package com.dynamiclogs.www;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static Log logger = LogFactory.getLog(Application.class);
	
	@Bean
	protected ServletContextListener listener() {
		return new ServletContextListener() {
			
			@Override
			public void contextInitialized(ServletContextEvent arg0) {
				logger.info("ServletContext initialized");
			}
			
			@Override
			public void contextDestroyed(ServletContextEvent arg0) {
				logger.info("ServeletContext destroyed");
			}
		};
	}
			
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}
