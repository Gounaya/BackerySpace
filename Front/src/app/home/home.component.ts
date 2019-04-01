import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/map';
import'rxjs/Rx';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  data : any={};
  constructor( private http: HttpClient){
    console.log('uuuu');
    this.ngOnInit();
  }
  title = 'Client';
  
  ngOnInit(){
    this.http.get('http://127.0.0.1:8886/produitHero').subscribe(data => {
      console.log(data);
      this.data = data
    })

  }

}