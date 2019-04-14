import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProduitfishService {
public host2 = 'https://fishback.herokuapp.com/product/star?fbclid=IwAR1HH1Q2TQG1KojAESrbZ2uaxOkQW74K6dVAht6V1_E4_51pDsE_q9LQGdY';
  constructor(private http: HttpClient) { }

  getProductHeroFish() {
    return this.http.get(this.host2);


  }
}



