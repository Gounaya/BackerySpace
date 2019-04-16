package com.fges.rizomm.m1.bakery.service;

import com.fges.rizomm.m1.bakery.entites.User;

public interface UserService {

	void save(User user);
	User findByUsername(String username);
}
