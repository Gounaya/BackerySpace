import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { ProduitsComponent } from './produits/produits.component';

import { FooterComponent } from './footer/footer.component';
import {HttpClientModule} from '@angular/common/http';
import { CartComponent } from './cart/cart.component';
import { HomeComponent } from './home/home.component';
import { ProduitsDetailsComponent } from './produits-details/produits-details.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,

    ProduitsComponent,
    FooterComponent,
    CartComponent,
    HomeComponent,
    ProduitsDetailsComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
// tslint:disable-next-line: deprecation
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
