package com.fges.rizomm.m1.bakery.service;

import com.fges.rizomm.m1.bakery.dao.ProduitRepository;
import com.fges.rizomm.m1.bakery.entites.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public ProduitServiceImpl(ProduitRepository produitRepository){
        this.produitRepository = produitRepository;
    }

   /* @Override
    public void save(Produit produit) {

    MultipartFile file = produit.getImage();

        if (null != file){
            try {
                produit.setPhoto(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        produit.setCreateDate(LocalDateTime.now());
        produitRepository.save(produit);

    }*/

    @Override
    public Optional<Produit> find(Long id) {
        return produitRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    @Override
    public Produit update(Produit produit) {
       return produitRepository.save(produit);
    }

    @Override
    public Produit getProductHero() {
        return produitRepository.getHero();
    }


}
