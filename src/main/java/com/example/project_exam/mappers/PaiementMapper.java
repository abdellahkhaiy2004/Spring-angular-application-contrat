package com.example.project_exam.mappers;

import com.example.project_exam.dtos.PaiementDTO;
import com.example.project_exam.entities.Paiement;
import org.springframework.stereotype.Component;

@Component
public class PaiementMapper {

    public PaiementDTO toDTO(Paiement paiement) {
        PaiementDTO dto = new PaiementDTO();
        dto.setId(paiement.getId());
        dto.setDate(paiement.getDate());
        dto.setMontant(paiement.getMontant());
        dto.setType(paiement.getType());
        dto.setContratId(paiement.getContrat() != null ? paiement.getContrat().getId() : null);
        return dto;
    }

    public Paiement toEntity(PaiementDTO dto) {
        Paiement paiement = new Paiement();
        paiement.setId(dto.getId());
        paiement.setDate(dto.getDate());
        paiement.setMontant(dto.getMontant());
        paiement.setType(dto.getType());
        return paiement;
    }
}
