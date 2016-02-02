package com.dynamiclogs.www.process.user.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.stereotype.Service;

import com.dynamiclogs.www.process.user.domain.User;
import com.dynamiclogs.www.process.user.repository.UserRepository;

@Service
public class AccountConnectionSignUpService implements ConnectionSignUp {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String execute(Connection<?> connection) {
		UserProfile profile = connection.fetchUserProfile();
		String userId = UUID.randomUUID().toString();
		User user = new User();
		user.setEmail(profile.getEmail());
		userRepository.save(user);
		return userId;
	}

}
