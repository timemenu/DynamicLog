package com.dynamiclogs.www.process.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dynamiclogs.www.process.user.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
