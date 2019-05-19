import { Component, OnInit } from '@angular/core';
import { ProduitsService } from '../produits.service';

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
this.produitService.getCartProduct()
.subscribe(produits =>  {
  this.produits = produits;
}, err => {
  console.log('error');
});

}}
