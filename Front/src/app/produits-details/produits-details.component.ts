import { Component, OnInit } from '@angular/core';
<<<<<<< HEAD
import { ProduitsService } from '../Services/produits.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Produits } from '../models/Produits';
=======
import { ProduitsService } from './../produits.service';
import { ActivatedRoute, Router } from '@angular/router';
>>>>>>> 067aa1661ffcac84e6f42fa21425fdd66efa0ede


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
