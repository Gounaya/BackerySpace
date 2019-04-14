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
	BCryptPasswordEncoder encoder;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void saveUser(User user) {
		  user.setPassword(encoder.encode(user.getPassword()));
		  user.setStatus("VERIFIED");
		  Role userRole = roleRepository.findByRole("SITE_USER");
		  user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		  userRepository.save(user);
	}

	@Override
	public Boolean isUserAlreadyPresent(User user) {
		// from website
		return null;
	}

}
