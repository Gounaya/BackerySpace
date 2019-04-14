package com.fges.rizomm.m1.bakery.entites;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.fges.rizomm.m1.bakery.entites.LigneCommande;
import com.fges.rizomm.m1.bakery.entites.Produit;

public class Panier {

	private Map<Long, LigneCommande> items = new HashMap<>();
			
	
	public void addArticle(Produit p, int quantite)
	{
		if(items.get(p.getIdProduit())==null)
		{
			LigneCommande lc = new LigneCommande();
			lc.setProduit(p);
			lc.setQuantite(quantite);
			lc.setPrix(p.getPrix());
		}
		else {
			LigneCommande lc = items.get(p.getIdProduit());
			lc.setQuantite(lc.getQuantite()+quantite);
		}
	}
	
	public Collection<LigneCommande> getItems()
	{
		return items.values();
	}
	
	public double getTotal()
	{
		double total=0;
		for (LigneCommande lc:items.values()) {
			total += lc.getPrix()*lc.getQuantite();
		}
		return total;
	}
	
	public int getSize()
	{
		return items.size();
	}
	
	public void deleteItem(Long idProduit)
	{
		items.remove(idProduit);
	}
}
