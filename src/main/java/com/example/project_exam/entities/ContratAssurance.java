package com.example.project_exam.entities;

import com.example.project_exam.enums.StatutContrat;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CONTRAT", discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratAssurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateSouscription;

    @Enumerated(EnumType.STRING)
    private StatutContrat statut;

    private Date dateValidation;

    private double montantCotisation;

    private int dureeContrat;

    private double tauxCouverture;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "contrat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Paiement> paiements;
}
