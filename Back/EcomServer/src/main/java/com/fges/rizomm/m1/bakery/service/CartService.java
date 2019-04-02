package com.fges.rizomm.m1.bakery.service;

import com.fges.rizomm.m1.bakery.entites.Produit;

import java.util.Map;

public interface CartService {

    void addProduit(Produit product);

    void removeProduit(Produit product);

    Map<Produit, Integer> getProduitsInCart();

    double getTotal();

}
