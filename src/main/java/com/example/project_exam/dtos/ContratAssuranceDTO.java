package com.example.project_exam.dtos;

import com.example.project_exam.enums.StatutContrat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratAssuranceDTO {
    private Long id;
    private Date dateSouscription;
    private StatutContrat statut;
    private Date dateValidation;
    private double montantCotisation;
    private int dureeContrat;
    private double tauxCouverture;
    private Long clientId;
    private String typeContrat;
}
