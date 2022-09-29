package com.finzly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finzly.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	User findOneByEmailAndPassword(String email, String password);
	
}
