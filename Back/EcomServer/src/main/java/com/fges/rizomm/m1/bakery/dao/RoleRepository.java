package com.fges.rizomm.m1.bakery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fges.rizomm.m1.bakery.entites.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	public Role findByRole(String role);
}
