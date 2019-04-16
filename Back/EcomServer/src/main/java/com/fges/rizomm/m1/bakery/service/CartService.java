package com.fges.rizomm.m1.bakery.service;

import com.fges.rizomm.m1.bakery.entites.Produit;

import java.util.Map;
import java.util.Optional;

public interface CartService {

    void addProduit(Produit produit);

    void removeProduit(Produit produit);

    Map<Produit, Integer> getProduitsInCart();

    void removeAll();

    double getTotal();

    void addProduitWithQuantity(Produit produit, int qte);

    void updateProduit(Produit produit, int qte);
}
