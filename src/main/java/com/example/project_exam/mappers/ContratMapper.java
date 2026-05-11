package com.example.project_exam.mappers;

import com.example.project_exam.dtos.*;
import com.example.project_exam.entities.*;
import org.springframework.stereotype.Component;

@Component
public class ContratMapper {

    public ContratAssuranceDTO toDTO(ContratAssurance contrat) {
        if (contrat instanceof ContratAutomobile ca) {
            return new ContratAutomobileDTO(
                    ca.getId(), ca.getDateSouscription(), ca.getStatut(),
                    ca.getDateValidation(), ca.getMontantCotisation(),
                    ca.getDureeContrat(), ca.getTauxCouverture(),
                    ca.getClient() != null ? ca.getClient().getId() : null,
                    ca.getNumImmatriculation(), ca.getMarque(), ca.getModele()
            );
        } else if (contrat instanceof ContratHabitation ch) {
            return new ContratHabitationDTO(
                    ch.getId(), ch.getDateSouscription(), ch.getStatut(),
                    ch.getDateValidation(), ch.getMontantCotisation(),
                    ch.getDureeContrat(), ch.getTauxCouverture(),
                    ch.getClient() != null ? ch.getClient().getId() : null,
                    ch.getTypeLogement(), ch.getAdresse(), ch.getSuperficie()
            );
        } else if (contrat instanceof ContratSante cs) {
            return new ContratSanteDTO(
                    cs.getId(), cs.getDateSouscription(), cs.getStatut(),
                    cs.getDateValidation(), cs.getMontantCotisation(),
                    cs.getDureeContrat(), cs.getTauxCouverture(),
                    cs.getClient() != null ? cs.getClient().getId() : null,
                    cs.getNiveauCouverture(), cs.getNombrePersonnesCouvertes()
            );
        }
        ContratAssuranceDTO dto = new ContratAssuranceDTO();
        dto.setId(contrat.getId());
        dto.setDateSouscription(contrat.getDateSouscription());
        dto.setStatut(contrat.getStatut());
        dto.setDateValidation(contrat.getDateValidation());
        dto.setMontantCotisation(contrat.getMontantCotisation());
        dto.setDureeContrat(contrat.getDureeContrat());
        dto.setTauxCouverture(contrat.getTauxCouverture());
        dto.setClientId(contrat.getClient() != null ? contrat.getClient().getId() : null);
        return dto;
    }
}
