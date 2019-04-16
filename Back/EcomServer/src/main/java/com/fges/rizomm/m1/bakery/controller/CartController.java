package com.fges.rizomm.m1.bakery.controller;

import com.fges.rizomm.m1.bakery.entites.Produit;
import com.fges.rizomm.m1.bakery.service.CartService;
import com.fges.rizomm.m1.bakery.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


@Controller
@RequestMapping("/cart")
public class CartController {


    private CartService cartService;

    private ProduitService produitService;

    @Autowired
    public CartController(CartService cartService, ProduitService produitService)
    {
        this.cartService = cartService;
        this.produitService = produitService;
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

        return ResponseEntity.status(HttpStatus.OK).body(cart); // TODO : retun total

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


    @SuppressWarnings("Duplicates")
    @DeleteMapping(value = "/removeAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> removeAll(){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        cartService.removeAll();

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @SuppressWarnings("Duplicates")
    @PostMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<Produit,Integer>> addProduitWithQuantityCart(@PathVariable("id") Long id, @RequestParam("qte") int qte){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        Produit Produit = produitService.find(id).orElse(null);

        if(Produit == null){
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }

        cartService.addProduitWithQuantity(Produit, qte);
        Map<Produit,Integer> cart = cartService.getProduitsInCart();
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @SuppressWarnings("Duplicates")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<Produit,Integer>> UpdateQuantityCart(@PathVariable("id") Long id, @RequestParam("qte") int qte){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        Produit Produit = produitService.find(id).orElse(null);

        if(Produit == null){
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }

        cartService.updateProduit(Produit, qte);
        Map<Produit,Integer> cart = cartService.getProduitsInCart();
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }


}
