import { ProduitsService } from '../Services/produits.service';
import { Component, OnInit, Input } from '@angular/core';
import { Produits } from '../models/Produits';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css']
})
export class ProduitsComponent implements OnInit {
/**
 *
 * @param produitService Appel du service de l'API dans le composant
 */
  constructor(private produitService: ProduitsService) { }

  produits: Produits;
  @Input()quantity=0;

/**
 * Recuperation des ressources depuis l'API pour affichage
 */
  ngOnInit() {
this.produitService.getAllProduits()
.pipe()
.subscribe(produits =>  {
  this.produits = produits;
}, err => {
  console.log('error');
});

  }

  onClickProduct(){

    this.quantity = this.quantity++;
    console.log(this.quantity);
  }



}
