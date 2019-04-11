import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProduitmealService {
public host3 = 'http://51.15.226.50:8080/api/products/productHero';
  constructor(private httpMeal: HttpClient ) { }

  getMealHero(){

    return this.httpMeal.get(this.host3);
  }
}




