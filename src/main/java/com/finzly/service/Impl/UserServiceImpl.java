package com.finzly.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.entity.User;
import com.finzly.repository.UserRepo;
import com.finzly.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo repo;
	
	
	

	@Override
	public User register(User user) {
		User userDetails = this.repo.save(user);
		return userDetails;
	}

	@Override
	public List<User> Users() {
		List<User> userDetails = this.repo.findAll(); 
		return userDetails;
	}
}
