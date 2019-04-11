import { Component, OnInit, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/map';
import { ProduitfishService } from '../Services/produitfish.service';
import { ProduitmealService } from '../Services/produitmeal.service';
import { ProduitsService } from '../Services/produits.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  title = 'Client';


  constructor( private fishservice: ProduitfishService, private mealservice: ProduitmealService, private breadService:ProduitsService){
  }
  fish: any;
  meal:any;
  produit:any


  ngOnInit() {

    // this.http.get('http://127.0.0.1:8887/produitHero').subscribe(data => {
    //   console.log(data);
    //   this.data = data;


this.fishservice.getProductHeroFish()
.subscribe(reponse1=>{
  this.fish=reponse1});

   this.mealservice.getMealHero()

  .subscribe(reponse2 => {
    this.meal = reponse2;
  });

  this.breadService.getProduitHero()
    .subscribe(reponse3=>{
      this.produit = reponse3;
    })
  }


  }




    // this.http.get('http://51.15.226.50:8080/api/products/productHero').subscribe(boucher =>{
    //   console.log(boucher);
    // this.meal = boucher;





