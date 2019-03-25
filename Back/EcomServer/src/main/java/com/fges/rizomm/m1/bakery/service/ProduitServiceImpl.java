package com.fges.rizomm.m1.bakery.service;

import com.fges.rizomm.m1.bakery.dao.ProduitRepository;
import com.fges.rizomm.m1.bakery.entites.Produit;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;

    @Autowired
    public ProduitServiceImpl(ProduitRepository produitRepository){
        this.produitRepository = produitRepository;
    }

    @Override
    public void save(Produit produit) {

        /*MultipartFile file = product.getImage();

        if (null != file){
            try {
                product.setPhoto(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        product.setCreateDate(LocalDateTime.now());
        productRepository.save(product);*/
    }

    @Override
    public Produit update(Produit produit) {
        return produitRepository.save(produit);
    }

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
}
