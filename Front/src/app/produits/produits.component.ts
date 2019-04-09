import { ProduitsService } from './../produits.service';
import { Component, OnInit } from '@angular/core';

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

  }



}
