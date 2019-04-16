package com.fges.rizomm.m1.bakery.service;


import com.fges.rizomm.m1.bakery.entites.Produit;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
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

    private Map<Produit, Integer> produits = new HashMap<>();

    @Override
    public void addProduit(Produit produit) {

        for (Map.Entry<Produit, Integer> e : produits.entrySet()) {
            if (e.getKey().getIdProduit() == produit.getIdProduit()) {
                e.setValue(e.getValue()+1);
                return;
            }
        }
        produits.put(produit, 1);
    }


    @Override
    public void addProduitWithQuantity(Produit produit, int qte) {

        for (Map.Entry<Produit, Integer> e : produits.entrySet()) {
            if (e.getKey().getIdProduit() == produit.getIdProduit()) {
                e.setValue(e.getValue() + qte);
                return;
            }
        }
        produits.put(produit, qte);

    }


    @Override
    public void removeProduit(Produit produit) {

        for (Map.Entry<Produit, Integer> e : produits.entrySet()) {
            if (e.getKey().getIdProduit() == produit.getIdProduit()) {
                    produits.remove(e.getKey());
            }
        }
    }

    @Override
    public void removeAll() {
        produits.clear();
    }

    @Override
    public void updateProduit(Produit produit, int qte) {
        for (Map.Entry<Produit, Integer> e : produits.entrySet()) {
            if (e.getKey().getIdProduit() == produit.getIdProduit()) {
                e.setValue(qte);
                if(e.getValue() > 1)
                {
                   return;

                } else if(e.getValue() <= 0)
                {
                    produits.remove(e.getKey());
                }
            }
        }
    }


    @Override
    public Map<Produit, Integer> getProduitsInCart() {
        return Collections.unmodifiableMap(produits);
    }

    @Override
    public double getTotal() {
        double totalPrice = 0;
        if(produits.size() > 0 && produits != null){
            for (Map.Entry<Produit, Integer> pair : produits.entrySet()) {
                totalPrice = totalPrice + pair.getKey().getPrix();
            }
        }
        return totalPrice;
    }



}
