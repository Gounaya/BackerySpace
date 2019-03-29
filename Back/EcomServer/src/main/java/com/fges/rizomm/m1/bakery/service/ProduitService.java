package com.fges.rizomm.m1.bakery.service;

import com.fges.rizomm.m1.bakery.entites.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitService {

    //void save(Produit product);

    Optional<Produit> find(Long id);

    void delete(Long id);

    List<Produit> findAll();

    Produit update(Produit product);
}
