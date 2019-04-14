package com.fges.rizomm.m1.bakery.service;

import com.fges.rizomm.m1.bakery.entites.User;

public interface UserService {

	public void saveUser(User user);
	
	public Boolean isUserAlreadyPresent(User user);
}
