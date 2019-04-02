package com.fges.rizomm.m1.bakery.service;

import com.fges.rizomm.m1.bakery.dao.ProduitRepository;
import com.fges.rizomm.m1.bakery.entites.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class CartServiceImpl implements CartService {

    private final ProduitRepository produitRepository;

    private Map<Produit, Integer> produits = new HashMap<>();

    @Autowired
    public CartServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public void addProduit(Produit produit) {

        if (this.produits.containsKey(produit)) {
            this.produits.replace(produit, this.produits.get(produit) + 1);
            System.out.println("Dodano produit");
        } else {
            this.produits.put(produit, 1);
        }
    }

    @Override
    public void removeProduit(Produit produit) {

        if (this.produits.containsKey(produit)) {
            if (this.produits.get(produit) > 1)
                this.produits.replace(produit, this.produits.get(produit) - 1);
            else if (this.produits.get(produit) == 1) {
                this.produits.remove(produit);
            }
        }
    }

    @Override
    public Map<Produit, Integer> getProduitsInCart() {
        return Collections.unmodifiableMap(this.produits);
    }

    @Override
    public double getTotal() {
        double totalPrice = 0;
        if(this.produits.size() > 0 && this.produits != null){
            for (Map.Entry<Produit, Integer> pair : produits.entrySet()) {
                totalPrice = totalPrice + pair.getKey().getPrix();
            }
        }
        return totalPrice;
    }

}
