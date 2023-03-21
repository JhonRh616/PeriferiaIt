import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CardComponent } from './card/card.component';
import { CardRepository } from './card/domain/card.repository';
import { TransactionComponent } from './transaction/transaction.component';
import { AppRoutingModule } from './app-routing.module';
import { NavbarComponent } from './navbar/navbar.component';
import { TransactionRepository } from './transaction/domain/transaction.repository';

@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    TransactionComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [CardRepository, TransactionRepository],
  bootstrap: [AppComponent]
})
export class AppModule { }
