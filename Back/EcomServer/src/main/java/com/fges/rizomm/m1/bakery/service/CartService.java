package com.fges.rizomm.m1.bakery.service;

import com.fges.rizomm.m1.bakery.entites.Produit;
import com.fges.rizomm.m1.bakery.entites.ProduitPanier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface CartService {

    void addProduit(Produit produit);

    void removeProduit(Produit produit);

    Map<Produit, Integer> getProduitsInCart();

    void removeAll();

    double getTotal();

    void addProduitWithQuantity(Produit produit, int qte);

    void updateProduit(Produit produit, int qte);

    ArrayList<ProduitPanier> convertMapToList();

}
