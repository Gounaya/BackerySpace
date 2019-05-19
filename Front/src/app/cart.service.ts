import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { carts } from './cart/cart';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
// export class CartService {

//   constructor(private http: HttpClient ) { }




// }
export class ArticleService {
  url = 'http://localhost:8887/cart/';
  constructor(private http: HttpClient) { }

  createcart(cart: carts): Observable<carts> {
      const httpHeaders = new HttpHeaders()
          .set('Content-Type', 'application/json');
      // tslint:disable-next-line:prefer-const
      let options = {
          headers: httpHeaders
      // tslint:disable-next-line:no-trailing-whitespace
      };        
      return this.http.post<carts>(this.url, cart, options);
  }
  postcart(cart: carts): Observable<HttpResponse<carts>> {
      const httpHeaders = new HttpHeaders({
           'Content-Type' : 'application/json'
      });
      return this.http.post<carts>(this.url, cart,
          {
            headers: httpHeaders,
            observe: 'response'
          }
      );
  }
  getAllcarts(): Observable<carts[]> {
      return this.http.get<carts[]>(this.url);
  }
}
