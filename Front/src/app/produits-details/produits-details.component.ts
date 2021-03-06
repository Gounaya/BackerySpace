import { Component, OnInit } from '@angular/core';
import { ProduitsService } from './../produits.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Produits } from '../models/Produits';


@Component({
  selector: 'app-produits-details',
  templateUrl: './produits-details.component.html',
  styleUrls: ['./produits-details.component.css']
})
export class ProduitsDetailsComponent implements OnInit {

  details : any;
  /**
   *
   * @param rest INJECTION DU SERVICE qui appel l'API pour recuperer les produits
   * @param route INJECTION DE MODULE pour recuperer le fragment iD de l'url
   */
  constructor(public rest: ProduitsService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.rest.getProduct(this.route.snapshot.params['id']).
    subscribe((data: {}) => {
      console.log(data);
      this.details = data;
    });
  }
}
