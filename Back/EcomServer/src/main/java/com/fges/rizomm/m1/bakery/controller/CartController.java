package com.fges.rizomm.m1.bakery.controller;

import com.fges.rizomm.m1.bakery.entites.Produit;
import com.fges.rizomm.m1.bakery.service.CartService;
import com.fges.rizomm.m1.bakery.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProduitService produitService;


    @GetMapping("/info")
    public String myCart(Model model){
        return "mycart";
    }

    @SuppressWarnings("Duplicates")
    @PostMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<Produit,Integer>> addProduitCart(@PathVariable Long id){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        Produit Produit = produitService.find(id).orElse(null);
        System.out.println(Produit.getDesignation());

        if(Produit == null){
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
        cartService.addProduit(Produit);
        Map<Produit,Integer> cart = cartService.getProduitsInCart();
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @SuppressWarnings("Duplicates")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<Produit, Integer>> findCart(){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<Produit,Integer> cart = cartService.getProduitsInCart();

        if(cart == null){
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }

    @SuppressWarnings("Duplicates")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> removeProduit(@PathVariable Long id){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        Produit Produit = produitService.find(id).orElse(null);

        if(Produit == null){
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
        cartService.removeProduit(Produit);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
