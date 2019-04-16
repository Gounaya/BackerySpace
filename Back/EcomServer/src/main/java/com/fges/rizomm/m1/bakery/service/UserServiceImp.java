package com.fges.rizomm.m1.bakery.service;

import java.util.Arrays;
import java.util.HashSet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fges.rizomm.m1.bakery.dao.RoleRepository;
import com.fges.rizomm.m1.bakery.dao.UserRepository;
import com.fges.rizomm.m1.bakery.entites.Role;
import com.fges.rizomm.m1.bakery.entites.User;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
