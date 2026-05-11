package com.example.project_exam.entities;

import com.example.project_exam.enums.TypeLogement;
import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("HABITATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratHabitation extends ContratAssurance {

    @Enumerated(EnumType.STRING)
    private TypeLogement typeLogement;

    private String adresse;

    private double superficie;
}
