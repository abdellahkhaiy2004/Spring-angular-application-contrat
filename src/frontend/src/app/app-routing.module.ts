import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { ClientsComponent } from './components/clients/clients.component';
import { ContratsComponent } from './components/contrats/contrats.component';
import { PaiementsComponent } from './components/paiements/paiements.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'clients', component: ClientsComponent, canActivate: [AuthGuard] },
  { path: 'contrats', component: ContratsComponent, canActivate: [AuthGuard] },
  { path: 'paiements', component: PaiementsComponent, canActivate: [AuthGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
