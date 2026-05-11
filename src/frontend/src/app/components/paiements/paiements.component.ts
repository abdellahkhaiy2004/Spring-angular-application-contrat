import { Component, OnInit } from '@angular/core';
import { Paiement } from '../../models/paiement.model';
import { PaiementService } from '../../services/paiement.service';

@Component({
  selector: 'app-paiements',
  templateUrl: './paiements.component.html'
})
export class PaiementsComponent implements OnInit {

  paiements: Paiement[] = [];
  newPaiement: Paiement = { contratId: 0, montant: 0, type: 'MENSUALITE' };
  contratIdRecherche = 0;
  showForm = false;

  constructor(private paiementService: PaiementService) {}

  ngOnInit(): void {}

  rechercher(): void {
    if (this.contratIdRecherche > 0) {
      this.paiementService.getByContrat(this.contratIdRecherche)
        .subscribe(data => this.paiements = data);
    }
  }

  savePaiement(): void {
    this.paiementService.save(this.newPaiement).subscribe(() => {
      this.rechercher();
      this.showForm = false;
    });
  }
}
