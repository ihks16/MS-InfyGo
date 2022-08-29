package com.infygo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infygo.entity.UserDetails;

public interface UserRepository extends JpaRepository< UserDetails, String>{

	public Optional<UserDetails> findByNameAndPhone(String name,String phone);
	
}
