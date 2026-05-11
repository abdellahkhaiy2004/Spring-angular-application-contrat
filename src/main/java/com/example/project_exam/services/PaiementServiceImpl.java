package com.example.project_exam.services;

import com.example.project_exam.dtos.PaiementDTO;
import com.example.project_exam.entities.ContratAssurance;
import com.example.project_exam.entities.Paiement;
import com.example.project_exam.mappers.PaiementMapper;
import com.example.project_exam.repositories.ContratAssuranceRepository;
import com.example.project_exam.repositories.PaiementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class PaiementServiceImpl implements PaiementService {

    private PaiementRepository paiementRepository;
    private ContratAssuranceRepository contratAssuranceRepository;
    private PaiementMapper paiementMapper;

    @Override
    public PaiementDTO savePaiement(PaiementDTO paiementDTO) {
        ContratAssurance contrat = contratAssuranceRepository.findById(paiementDTO.getContratId())
                .orElseThrow(() -> new RuntimeException("Contrat non trouvé : " + paiementDTO.getContratId()));
        Paiement paiement = paiementMapper.toEntity(paiementDTO);
        paiement.setDate(new Date());
        paiement.setContrat(contrat);
        return paiementMapper.toDTO(paiementRepository.save(paiement));
    }

    @Override
    public List<PaiementDTO> getPaiementsByContratId(Long contratId) {
        return paiementRepository.findByContratId(contratId)
                .stream()
                .map(paiementMapper::toDTO)
                .collect(Collectors.toList());
    }
}
