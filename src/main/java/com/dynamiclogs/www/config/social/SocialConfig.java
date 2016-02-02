package com.dynamiclogs.www.config.social;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;

import com.dynamiclogs.www.process.user.service.AccountConnectionSignUpService;

@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
		connectionFactoryConfigurer.addConnectionFactory(new FacebookConnectionFactory(
	            environment.getProperty("spring.social.facebook.appId"),
	            environment.getProperty("spring.social.facebook.appSecret")));
	}

	@Override
	public UserIdSource getUserIdSource() {
		return new AuthenticationNameUserIdSource();
	}

	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
		JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
		repository.setConnectionSignUp(new AccountConnectionSignUpService());
		return repository;
	}
}
