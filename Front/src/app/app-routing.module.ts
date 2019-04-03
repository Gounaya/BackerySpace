import { ProduitsDetailsComponent } from './produits-details/produits-details.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProduitsComponent } from './produits/produits.component';
import { CartComponent } from './cart/cart.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [
  {path: 'produits', component: ProduitsComponent},
  {path: 'cart', component: CartComponent},
  {path: '', component: HomeComponent},
  {path: 'produits/:id', component: ProduitsDetailsComponent}



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
