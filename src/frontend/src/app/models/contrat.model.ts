export type StatutContrat = 'EN_COURS' | 'VALIDE' | 'RESILIE';
export type TypeLogement = 'APPARTEMENT' | 'MAISON' | 'LOCAL_COMMERCIAL';
export type NiveauCouverture = 'BASIQUE' | 'INTERMEDIAIRE' | 'PREMIUM';

export interface ContratAssurance {
  id?: number;
  dateSouscription?: string;
  statut?: StatutContrat;
  dateValidation?: string;
  montantCotisation: number;
  dureeContrat: number;
  tauxCouverture: number;
  clientId: number;
  typeContrat?: string;
}

export interface ContratAutomobile extends ContratAssurance {
  numImmatriculation: string;
  marque: string;
  modele: string;
}

export interface ContratHabitation extends ContratAssurance {
  typeLogement: TypeLogement;
  adresse: string;
  superficie: number;
}

export interface ContratSante extends ContratAssurance {
  niveauCouverture: NiveauCouverture;
  nombrePersonnesCouvertes: number;
}
