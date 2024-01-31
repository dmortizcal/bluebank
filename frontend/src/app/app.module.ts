import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {MaterialModule} from "./material.module";
import { BaseComponent } from './components/base/base.component';
import { NavbarComponent } from './components/base/navbar/navbar.component';
import { FooterComponent } from './components/base/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import {ClientsComponent} from './components/clients/clients.component';
import {FormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {NewClientDialog} from "./components/clients/dialogs/new_client_dialog";
import { ViewAccountsDialogComponent } from './components/clients/dialogs/view-accounts-dialog.component';
import { NewAccountDialogComponent } from './components/clients/dialogs/new-account-dialog.component';
import { TransactionsComponent } from './components/transactions/transactions.component';
import { NewConsignmentComponent } from './components/transactions/dialogs/new-consignment.component';
import { NewRetirementComponent } from './components/transactions/dialogs/new-retirement.component';
import { TransactionsDetailsComponent } from './components/transactions/dialogs/transactions-details.component';

@NgModule({
  declarations: [
    AppComponent,
    BaseComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    ClientsComponent,
    NewClientDialog,
    ViewAccountsDialogComponent,
    NewAccountDialogComponent,
    TransactionsComponent,
    NewConsignmentComponent,
    NewRetirementComponent,
    TransactionsDetailsComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MaterialModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
