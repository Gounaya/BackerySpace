package com.fges.rizomm.m1.bakery.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fges.rizomm.m1.bakery.entites.Produit;
import org.springframework.data.jpa.repository.Query;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    @Query("select p from Produit p where p.selected=1")
    Produit getHero();
}
