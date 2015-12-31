package com.dynamiclogs.www.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * 레파지토리 연동 클래스입니다.
 *
 * com.dynamiclogs.www.config
 * RepositoryConfiguration.java
 *
 * @author : quickmenu
 * @date : 2015. 12. 31.
 * @version : 1.0
 *
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.dynamiclogs.www.process"})
@EnableJpaRepositories(basePackages = {"com.dynamiclogs.www.process"})
@EnableTransactionManagement
public class RepositoryConfiguration { }
