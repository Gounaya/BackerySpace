package com.fges.rizomm.m1.bakery.service;

import com.fges.rizomm.m1.bakery.entites.Produit;

import java.util.Map;

public interface CartService {

    void addProduct(Produit produit);

    void removeProduct(Produit produit);

    Map<Produit, Integer> getProductsInCart();

    double getTotal();
}
