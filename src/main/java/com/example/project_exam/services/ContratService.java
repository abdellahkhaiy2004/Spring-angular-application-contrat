package com.example.project_exam.services;

import com.example.project_exam.dtos.*;

import java.util.List;

public interface ContratService {
    ContratAutomobileDTO saveContratAutomobile(ContratAutomobileDTO dto);
    ContratHabitationDTO saveContratHabitation(ContratHabitationDTO dto);
    ContratSanteDTO saveContratSante(ContratSanteDTO dto);
    ContratAssuranceDTO getContratById(Long id);
    List<ContratAssuranceDTO> getAllContrats();
    ContratAssuranceDTO validerContrat(Long id);
    ContratAssuranceDTO resilierContrat(Long id);
}
