package com.example.project_exam.dtos;

import com.example.project_exam.enums.StatutContrat;
import com.example.project_exam.enums.TypeLogement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratHabitationDTO extends ContratAssuranceDTO {
    private TypeLogement typeLogement;
    private String adresse;
    private double superficie;

    public ContratHabitationDTO(Long id, Date dateSouscription, StatutContrat statut,
                                 Date dateValidation, double montantCotisation,
                                 int dureeContrat, double tauxCouverture, Long clientId,
                                 TypeLogement typeLogement, String adresse, double superficie) {
        super(id, dateSouscription, statut, dateValidation, montantCotisation, dureeContrat, tauxCouverture, clientId, "HABITATION");
        this.typeLogement = typeLogement;
        this.adresse = adresse;
        this.superficie = superficie;
    }
}
