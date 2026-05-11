package com.example.project_exam.services;

import com.example.project_exam.dtos.ClientDTO;
import com.example.project_exam.dtos.ContratAssuranceDTO;
import com.example.project_exam.entities.Client;
import com.example.project_exam.mappers.ClientMapper;
import com.example.project_exam.mappers.ContratMapper;
import com.example.project_exam.repositories.ClientRepository;
import com.example.project_exam.repositories.ContratAssuranceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private ContratAssuranceRepository contratAssuranceRepository;
    private ClientMapper clientMapper;
    private ContratMapper contratMapper;

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = clientMapper.toEntity(clientDTO);
        return clientMapper.toDTO(clientRepository.save(client));
    }

    @Override
    public ClientDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé : " + id));
        return clientMapper.toDTO(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<ContratAssuranceDTO> getContratsByClientId(Long clientId) {
        return contratAssuranceRepository.findByClientId(clientId)
                .stream()
                .map(contratMapper::toDTO)
                .collect(Collectors.toList());
    }
}
