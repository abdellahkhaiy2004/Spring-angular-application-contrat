package com.example.project_exam.dtos;

import com.example.project_exam.enums.NiveauCouverture;
import com.example.project_exam.enums.StatutContrat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratSanteDTO extends ContratAssuranceDTO {
    private NiveauCouverture niveauCouverture;
    private int nombrePersonnesCouvertes;

    public ContratSanteDTO(Long id, Date dateSouscription, StatutContrat statut,
                            Date dateValidation, double montantCotisation,
                            int dureeContrat, double tauxCouverture, Long clientId,
                            NiveauCouverture niveauCouverture, int nombrePersonnesCouvertes) {
        super(id, dateSouscription, statut, dateValidation, montantCotisation, dureeContrat, tauxCouverture, clientId, "SANTE");
        this.niveauCouverture = niveauCouverture;
        this.nombrePersonnesCouvertes = nombrePersonnesCouvertes;
    }
}
