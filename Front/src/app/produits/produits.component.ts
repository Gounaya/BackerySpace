import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/map';
import'rxjs/Rx';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css']
})
export class ProduitsComponent implements OnInit {

  data : any={};
  constructor( private http: HttpClient){
    console.log('uuuu');
    this.ngOnInit();
  }
  title = 'Client';
  
  ngOnInit(){
    this.http.get('http://127.0.0.1:8888/produits').subscribe(data => {
      console.log(data);
      this.data = data
    })

  }

}
