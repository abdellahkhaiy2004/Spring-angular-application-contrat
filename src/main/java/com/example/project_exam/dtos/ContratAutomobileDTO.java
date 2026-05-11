package com.example.project_exam.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import com.example.project_exam.enums.StatutContrat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratAutomobileDTO extends ContratAssuranceDTO {
    private String numImmatriculation;
    private String marque;
    private String modele;

    public ContratAutomobileDTO(Long id, Date dateSouscription, StatutContrat statut,
                                 Date dateValidation, double montantCotisation,
                                 int dureeContrat, double tauxCouverture, Long clientId,
                                 String numImmatriculation, String marque, String modele) {
        super(id, dateSouscription, statut, dateValidation, montantCotisation, dureeContrat, tauxCouverture, clientId, "AUTOMOBILE");
        this.numImmatriculation = numImmatriculation;
        this.marque = marque;
        this.modele = modele;
    }
}
