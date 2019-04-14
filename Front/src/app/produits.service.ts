import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProduitsService {

  public host = 'http://localhost:8887';

  constructor(private http: HttpClient) { }
  private extractData(res: Response) {
    let body = res;
    return body || { };
  }

  /**
   * Cette methode appelle l'API et recupere tous les produits
   */
  getAllProduits() {
    return this.http.get(this.host + '/produits');
  }

getCartProduct() {

  return this.http.get(this.host + '/cart');


}


  getProduitHero() {

    return this.http.get(this.host + '/produitHero');
  }

  /**
   * Cette methode appelle les ressources de l'API par Id de produit
   */

  getProduct(id): Observable<any> {
    return this.http.get(this.host + '/produits/' + id)
    .pipe(
      map(this.extractData));
  }

}
