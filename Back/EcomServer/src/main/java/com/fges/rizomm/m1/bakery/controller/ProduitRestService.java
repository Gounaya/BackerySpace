package com.fges.rizomm.m1.bakery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fges.rizomm.m1.bakery.dao.ProduitRepository;
import com.fges.rizomm.m1.bakery.entites.Produit;

@RestController
public class 	ProduitRestService {
	
	@Autowired
	private ProduitRepository produitRepository;
	
	@GetMapping(value="/produits")
	public List<Produit> getProduits()
	{
		return produitRepository.findAll();
	}
	
	@GetMapping(value="/produits/{id}")
	public Optional<Produit> getProduit(@PathVariable Long id)
	{
		return produitRepository.findById(id);
	}
	
	@PostMapping(value="/produits")
	public Produit saveProduit(@RequestBody Produit p)
	{
		return produitRepository.save(p);
	}
	
	@DeleteMapping(value="/produits/{id}")
	public void deleteProduit(@PathVariable Long id)
	{
		produitRepository.deleteById(id);
	}
	
	@PutMapping(value="/produits/{id}")
	public Produit updateProduit(@PathVariable Long id, @RequestBody Produit p)
	{
		p.setIdProduit(id);
		return produitRepository.save(p);
	}



}
