package com.fges.rizomm.m1.bakery.controller;

import com.fges.rizomm.m1.bakery.entites.Produit;
import com.fges.rizomm.m1.bakery.service.CartService;
import com.fges.rizomm.m1.bakery.service.CartServiceImpl;
import com.fges.rizomm.m1.bakery.service.ProduitService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


    @GetMapping("/shoppingCart")
    public ModelAndView Cart(){
        ModelAndView modelAndView = new ModelAndView("/Cart");
        modelAndView.addObject("products", cartService.getProduitsInCart());
        modelAndView.addObject("total", cartService.getTotal());
        return modelAndView;
    }

    @GetMapping(value = "/Cart/addProduct/{idProduit}")
    public ModelAndView addProductToCart(@PathVariable("idProduit") Long idProduit){
        Optional<Produit> product = produitService.find(idProduit);
        cartService.addProduit(product);
        return Cart();
    }

    @GetMapping("/Cart/removeProduct/{idProduit}")
    public ModelAndView removeProductFromCart(@PathVariable("idProduit") Long idProduit) {
        Optional<Produit> product = produitService.find(idProduit);
        cartService.removeProduit(product);
        return Cart();
    }

}
