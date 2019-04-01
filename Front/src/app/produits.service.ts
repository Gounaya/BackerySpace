import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProduitsService {

  public host = 'http://localhost:8886';

  constructor(private http: HttpClient) { }

  getAllProduits() {
    return this.http.get(this.host + '/produits');
  }

}
