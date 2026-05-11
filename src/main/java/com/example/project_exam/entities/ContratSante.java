package com.example.project_exam.entities;

import com.example.project_exam.enums.NiveauCouverture;
import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("SANTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratSante extends ContratAssurance {

    @Enumerated(EnumType.STRING)
    private NiveauCouverture niveauCouverture;

    private int nombrePersonnesCouvertes;
}
