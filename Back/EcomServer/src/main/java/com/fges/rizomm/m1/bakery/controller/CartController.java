package com.fges.rizomm.m1.bakery.controller;

import com.fges.rizomm.m1.bakery.entites.Produit;
import com.fges.rizomm.m1.bakery.service.CartService;
import com.fges.rizomm.m1.bakery.service.CartServiceImpl;
import com.fges.rizomm.m1.bakery.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CartController {

    private final CartService cartService;

    private final ProduitService produitService;

    @Autowired
    public CartController(CartService cartService, ProduitService produitService) {
        this.cartService = cartService;
        this.produitService = produitService;
    }


    @GetMapping("/Cart")
    public ModelAndView Cart(){
        ModelAndView modelAndView = new ModelAndView("/Cart");
        modelAndView.addObject("products", cartService.getProduitsInCart());
        modelAndView.addObject("total", cartService.getTotal());
        return modelAndView;
    }

    @PostMapping(value = "/Cart/addProduct/{idProduit}")
    public ModelAndView addProductToCart(@PathVariable("idProduit") Long idProduit){
        Produit product = produitService.find(idProduit).orElse(null);
        cartService.addProduit(product);
        return Cart();
    }

    @GetMapping("/Cart/removeProduct/{idProduit}")
    public ModelAndView removeProductFromCart(@PathVariable("idProduit") Long idProduit) {
        Produit product = produitService.find(idProduit).orElse(null);
        cartService.removeProduit(product);
        return Cart();
    }

}
