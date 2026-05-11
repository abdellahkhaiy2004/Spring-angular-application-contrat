package com.example.project_exam.web;

import com.example.project_exam.dtos.ClientDTO;
import com.example.project_exam.dtos.ContratAssuranceDTO;
import com.example.project_exam.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientRestController {

    private ClientService clientService;

    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(clientService.getClientById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ClientDTO> saveClient(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.saveClient(clientDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        try {
            clientService.getClientById(id);
            clientDTO.setId(id);
            return ResponseEntity.ok(clientService.saveClient(clientDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        try {
            clientService.getClientById(id);
            clientService.deleteClient(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/contrats")
    public ResponseEntity<List<ContratAssuranceDTO>> getContratsByClient(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(clientService.getContratsByClientId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
