import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { ClientsComponent } from './components/clients/clients.component';
import { ContratsComponent } from './components/contrats/contrats.component';
import { PaiementsComponent } from './components/paiements/paiements.component';
import { JwtInterceptor } from './interceptors/jwt.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ClientsComponent,
    ContratsComponent,
    PaiementsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
