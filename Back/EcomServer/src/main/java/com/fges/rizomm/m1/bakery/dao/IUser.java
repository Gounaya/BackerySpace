package com.fges.rizomm.m1.bakery.dao;

import com.fges.rizomm.m1.bakery.entites.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;



public interface IUser extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByMailAndPassword(String mail, String password);
}
