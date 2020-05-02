package com.Deadlybeat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Deadlybeat.model.User;

public interface userRegistrationRepository extends JpaRepository<User, Integer>{

	//custom method to find user by email id
	List<User> findByEmail(String email);

}
