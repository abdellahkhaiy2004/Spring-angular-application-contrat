import { Component, OnInit } from '@angular/core';
import { ContratAssurance, ContratAutomobile } from '../../models/contrat.model';
import { ContratService } from '../../services/contrat.service';

@Component({
  selector: 'app-contrats',
  templateUrl: './contrats.component.html'
})
export class ContratsComponent implements OnInit {

  contrats: ContratAssurance[] = [];
  newContrat: ContratAutomobile = {
    clientId: 0, montantCotisation: 0, dureeContrat: 0,
    tauxCouverture: 0, numImmatriculation: '', marque: '', modele: ''
  };
  showForm = false;

  constructor(private contratService: ContratService) {}

  ngOnInit(): void {
    this.loadContrats();
  }

  loadContrats(): void {
    this.contratService.getAll().subscribe(data => this.contrats = data);
  }

  saveContrat(): void {
    this.contratService.saveAutomobile(this.newContrat).subscribe(() => {
      this.loadContrats();
      this.showForm = false;
    });
  }

  valider(id: number): void {
    this.contratService.valider(id).subscribe(() => this.loadContrats());
  }

  resilier(id: number): void {
    this.contratService.resilier(id).subscribe(() => this.loadContrats());
  }
}
