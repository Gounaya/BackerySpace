import { Component, OnInit, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/map';
<<<<<<< HEAD
import { ProduitfishService } from '../Services/produitfish.service';
import { ProduitmealService } from '../Services/produitmeal.service';
import { ProduitsService } from '../Services/produits.service';
=======
>>>>>>> 067aa1661ffcac84e6f42fa21425fdd66efa0ede

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  title = 'Client';


<<<<<<< HEAD
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
=======
  @Input() data : any;
  constructor( private http: HttpClient){
    console.log('uuuu');
    this.ngOnInit();
  }
  title = 'Client';

  ngOnInit(){
    this.http.get('http://127.0.0.1:8886/produitHero').subscribe(data => {
      this.data = data;
>>>>>>> 067aa1661ffcac84e6f42fa21425fdd66efa0ede
    })
  }


  }




    // this.http.get('http://51.15.226.50:8080/api/products/productHero').subscribe(boucher =>{
    //   console.log(boucher);
    // this.meal = boucher;





