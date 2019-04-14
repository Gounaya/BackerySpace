package com.fges.rizomm.m1.bakery.entites;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Categorie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategorie;
	@NotEmpty
	@Size(min=4, max=20)
	private String nomCategorie;
	@Size(min=4)
	private String description;
	@Lob // pour le coté MySQL (type short binaire)
	private byte[] photo;
	private String nomPhoto;
	
	@OneToMany(mappedBy="categorie")
	private Collection<Produit> produits;
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Categorie(String nomCategorie, String description, byte[] photo, String nomPhoto) {
		super();
		this.nomCategorie = nomCategorie;
		this.description = description;
		this.photo = photo;
		this.nomPhoto = nomPhoto;
	}
	
	public Long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getNomPhoto() {
		return nomPhoto;
	}
	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}
	public Collection<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}


}
