import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProduitsService } from './../produits.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-produits-details',
  templateUrl: './produits-details.component.html',
  styleUrls: ['./produits-details.component.css']
})
export class ProduitsDetailsComponent implements OnInit {

  details : any;
  constructor(public rest:ProduitsService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.rest.getProduct(this.route.snapshot.params['id']).
    subscribe((data: {}) => {
      console.log(data);
      this.details = data;
    });
  }
}
