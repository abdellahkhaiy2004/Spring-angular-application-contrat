package com.example.project_exam.entities;

import com.example.project_exam.enums.TypePaiement;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private double montant;

    @Enumerated(EnumType.STRING)
    private TypePaiement type;

    @ManyToOne
    @JoinColumn(name = "contrat_id")
    private ContratAssurance contrat;
}
