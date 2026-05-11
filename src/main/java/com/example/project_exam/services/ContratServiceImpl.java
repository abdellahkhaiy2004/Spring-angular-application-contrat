package com.example.project_exam.services;

import com.example.project_exam.dtos.*;
import com.example.project_exam.entities.*;
import com.example.project_exam.enums.StatutContrat;
import com.example.project_exam.mappers.ContratMapper;
import com.example.project_exam.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ContratServiceImpl implements ContratService {

    private ContratAssuranceRepository contratAssuranceRepository;
    private ContratAutomobileRepository contratAutomobileRepository;
    private ContratHabitationRepository contratHabitationRepository;
    private ContratSanteRepository contratSanteRepository;
    private ClientRepository clientRepository;
    private ContratMapper contratMapper;

    @Override
    public ContratAutomobileDTO saveContratAutomobile(ContratAutomobileDTO dto) {
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client non trouvé : " + dto.getClientId()));
        ContratAutomobile contrat = new ContratAutomobile();
        contrat.setClient(client);
        contrat.setDateSouscription(new Date());
        contrat.setStatut(StatutContrat.EN_COURS);
        contrat.setMontantCotisation(dto.getMontantCotisation());
        contrat.setDureeContrat(dto.getDureeContrat());
        contrat.setTauxCouverture(dto.getTauxCouverture());
        contrat.setNumImmatriculation(dto.getNumImmatriculation());
        contrat.setMarque(dto.getMarque());
        contrat.setModele(dto.getModele());
        ContratAutomobile saved = contratAutomobileRepository.save(contrat);
        return (ContratAutomobileDTO) contratMapper.toDTO(saved);
    }

    @Override
    public ContratHabitationDTO saveContratHabitation(ContratHabitationDTO dto) {
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client non trouvé : " + dto.getClientId()));
        ContratHabitation contrat = new ContratHabitation();
        contrat.setClient(client);
        contrat.setDateSouscription(new Date());
        contrat.setStatut(StatutContrat.EN_COURS);
        contrat.setMontantCotisation(dto.getMontantCotisation());
        contrat.setDureeContrat(dto.getDureeContrat());
        contrat.setTauxCouverture(dto.getTauxCouverture());
        contrat.setTypeLogement(dto.getTypeLogement());
        contrat.setAdresse(dto.getAdresse());
        contrat.setSuperficie(dto.getSuperficie());
        ContratHabitation saved = contratHabitationRepository.save(contrat);
        return (ContratHabitationDTO) contratMapper.toDTO(saved);
    }

    @Override
    public ContratSanteDTO saveContratSante(ContratSanteDTO dto) {
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client non trouvé : " + dto.getClientId()));
        ContratSante contrat = new ContratSante();
        contrat.setClient(client);
        contrat.setDateSouscription(new Date());
        contrat.setStatut(StatutContrat.EN_COURS);
        contrat.setMontantCotisation(dto.getMontantCotisation());
        contrat.setDureeContrat(dto.getDureeContrat());
        contrat.setTauxCouverture(dto.getTauxCouverture());
        contrat.setNiveauCouverture(dto.getNiveauCouverture());
        contrat.setNombrePersonnesCouvertes(dto.getNombrePersonnesCouvertes());
        ContratSante saved = contratSanteRepository.save(contrat);
        return (ContratSanteDTO) contratMapper.toDTO(saved);
    }

    @Override
    public ContratAssuranceDTO getContratById(Long id) {
        ContratAssurance contrat = contratAssuranceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrat non trouvé : " + id));
        return contratMapper.toDTO(contrat);
    }

    @Override
    public List<ContratAssuranceDTO> getAllContrats() {
        return contratAssuranceRepository.findAll()
                .stream()
                .map(contratMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ContratAssuranceDTO validerContrat(Long id) {
        ContratAssurance contrat = contratAssuranceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrat non trouvé : " + id));
        contrat.setStatut(StatutContrat.VALIDE);
        contrat.setDateValidation(new Date());
        return contratMapper.toDTO(contratAssuranceRepository.save(contrat));
    }

    @Override
    public ContratAssuranceDTO resilierContrat(Long id) {
        ContratAssurance contrat = contratAssuranceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrat non trouvé : " + id));
        contrat.setStatut(StatutContrat.RESILIE);
        return contratMapper.toDTO(contratAssuranceRepository.save(contrat));
    }
}
