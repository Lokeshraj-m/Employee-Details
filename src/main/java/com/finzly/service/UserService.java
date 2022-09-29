package com.finzly.service;

import java.util.List;

import com.finzly.entity.User;

public interface UserService {
	
	public  User register(User user);
	
	public List<User> Users();
	

}
