package com.example.project_exam.services;

import com.example.project_exam.dtos.PaiementDTO;

import java.util.List;

public interface PaiementService {
    PaiementDTO savePaiement(PaiementDTO paiementDTO);
    List<PaiementDTO> getPaiementsByContratId(Long contratId);
}
