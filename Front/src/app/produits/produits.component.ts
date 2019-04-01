import { ProduitsService } from './../produits.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css']
})
export class ProduitsComponent implements OnInit {

  constructor(private produitService: ProduitsService) { }
 produits;
  ngOnInit() {
this.produitService.getAllProduits()
.subscribe(produits =>  {
  this.produits = produits;
}, err => {
  console.log('error');
});

  }

  description() {
    alert('ok');
  }


}
