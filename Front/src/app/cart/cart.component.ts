import { Component, OnInit } from '@angular/core';
<<<<<<< HEAD
import { ProduitsService } from '../Services/produits.service';
=======
import { ProduitsService } from '../produits.service';
>>>>>>> 067aa1661ffcac84e6f42fa21425fdd66efa0ede

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  constructor(private produitService: ProduitsService) { }

  produits: any;

/**
 * Recuperation des ressources depuis l'API pour affichage
 */
  ngOnInit() {
this.produitService.getAllProduits()
.subscribe(produits =>  {
  this.produits = produits;
}, err => {
  console.log('error');
});

}}
