import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ContratAssurance, ContratAutomobile, ContratHabitation, ContratSante } from '../models/contrat.model';

@Injectable({ providedIn: 'root' })
export class ContratService {

  private apiUrl = 'http://localhost:8080/api/contrats';

  constructor(private http: HttpClient) {}

  getAll(): Observable<ContratAssurance[]> {
    return this.http.get<ContratAssurance[]>(this.apiUrl);
  }

  getById(id: number): Observable<ContratAssurance> {
    return this.http.get<ContratAssurance>(`${this.apiUrl}/${id}`);
  }

  saveAutomobile(contrat: ContratAutomobile): Observable<ContratAutomobile> {
    return this.http.post<ContratAutomobile>(`${this.apiUrl}/automobile`, contrat);
  }

  saveHabitation(contrat: ContratHabitation): Observable<ContratHabitation> {
    return this.http.post<ContratHabitation>(`${this.apiUrl}/habitation`, contrat);
  }

  saveSante(contrat: ContratSante): Observable<ContratSante> {
    return this.http.post<ContratSante>(`${this.apiUrl}/sante`, contrat);
  }

  valider(id: number): Observable<ContratAssurance> {
    return this.http.put<ContratAssurance>(`${this.apiUrl}/${id}/valider`, {});
  }

  resilier(id: number): Observable<ContratAssurance> {
    return this.http.put<ContratAssurance>(`${this.apiUrl}/${id}/resilier`, {});
  }
}
