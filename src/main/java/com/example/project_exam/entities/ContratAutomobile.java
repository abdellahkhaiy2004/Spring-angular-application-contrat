package com.example.project_exam.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("AUTOMOBILE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratAutomobile extends ContratAssurance {

    private String numImmatriculation;

    private String marque;

    private String modele;
}
