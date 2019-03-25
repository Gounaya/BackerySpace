package com.fges.rizomm.m1.bakery.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fges.rizomm.m1.bakery.dao.ProduitRepository;


@SpringBootApplication
public class DemoSpringLoginApplication {
	
	/*@Autowired
	private ProduitRepository pr;*/
	
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringLoginApplication.class, args);
	}

	/*
	 *  Afin de tester une API Rest (couche DAO) ajouter implements CommandLineRunner
	 * 
	 * @Override
	public void run(String... args) throws Exception {
	
		
		pr.findAll().forEach(c->{
			System.out.println(c.getDesignation());
		});
			
		}*/
	
	

}
