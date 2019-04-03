import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProduitsService {

  public host = 'http://localhost:8886';

  constructor(private http: HttpClient) { }
  private extractData(res: Response) {
    let body = res;
    return body || { };
  }

  getAllProduits() {
    return this.http.get(this.host + '/produits');
  }

  getProduct(id): Observable<any> {
    return this.http.get(this.host + '/produits/' + id).pipe(
      map(this.extractData));
  }

}
