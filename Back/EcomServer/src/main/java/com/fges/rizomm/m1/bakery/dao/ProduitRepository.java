package com.fges.rizomm.m1.bakery.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fges.rizomm.m1.bakery.entites.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
