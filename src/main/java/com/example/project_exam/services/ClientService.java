package com.example.project_exam.services;

import com.example.project_exam.dtos.ClientDTO;
import com.example.project_exam.dtos.ContratAssuranceDTO;

import java.util.List;

public interface ClientService {
    ClientDTO saveClient(ClientDTO clientDTO);
    ClientDTO getClientById(Long id);
    List<ClientDTO> getAllClients();
    void deleteClient(Long id);
    List<ContratAssuranceDTO> getContratsByClientId(Long clientId);
}
