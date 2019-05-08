package com.fges.rizomm.m1.bakery.controller;

import com.fges.rizomm.m1.bakery.entites.Produit;
import com.fges.rizomm.m1.bakery.entites.ProduitPanier;
import com.fges.rizomm.m1.bakery.service.CartService;
import com.fges.rizomm.m1.bakery.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;


@RestController
@RequestMapping("/cart")
public class CartController {


    @Autowired
    private CartService cartService;

    @Autowired
    private ProduitService produitService;

    @SuppressWarnings("Duplicates")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<ProduitPanier>> findCart(){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<Produit,Integer> cart = cartService.getProduitsInCart();

        if(cart == null){
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }

        ArrayList<ProduitPanier> list = cartService.convertMapToList();
        return ResponseEntity.status(HttpStatus.OK).body(list);

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
    public ResponseEntity<ArrayList<ProduitPanier>> addProduitWithQuantityCart(@PathVariable("id") Long id, @RequestParam("qte") int qte){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        Produit Produit = produitService.find(id).orElse(null);

        if(Produit == null){
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }

        cartService.addProduitWithQuantity(Produit, qte);
        Map<Produit,Integer> cart = cartService.getProduitsInCart();

        ArrayList<ProduitPanier> list = cartService.convertMapToList();

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @SuppressWarnings("Duplicates")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArrayList<ProduitPanier>> UpdateQuantityCart(@PathVariable("id") Long id, @RequestParam("qte") int qte){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        Produit Produit = produitService.find(id).orElse(null);

        if(Produit == null){
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }

        cartService.updateProduit(Produit, qte);
        Map<Produit,Integer> cart = cartService.getProduitsInCart();

        ArrayList<ProduitPanier> list = cartService.convertMapToList();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }


}
