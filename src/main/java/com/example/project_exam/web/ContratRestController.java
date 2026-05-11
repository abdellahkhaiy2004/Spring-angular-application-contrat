package com.example.project_exam.web;

import com.example.project_exam.dtos.*;
import com.example.project_exam.services.ContratService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@AllArgsConstructor
public class ContratRestController {

    private ContratService contratService;

    @GetMapping
    public List<ContratAssuranceDTO> getAllContrats() {
        return contratService.getAllContrats();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratAssuranceDTO> getContratById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(contratService.getContratById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/automobile")
    public ResponseEntity<ContratAutomobileDTO> saveContratAutomobile(@RequestBody ContratAutomobileDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contratService.saveContratAutomobile(dto));
    }

    @PostMapping("/habitation")
    public ResponseEntity<ContratHabitationDTO> saveContratHabitation(@RequestBody ContratHabitationDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contratService.saveContratHabitation(dto));
    }

    @PostMapping("/sante")
    public ResponseEntity<ContratSanteDTO> saveContratSante(@RequestBody ContratSanteDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contratService.saveContratSante(dto));
    }

    @PutMapping("/{id}/valider")
    public ResponseEntity<ContratAssuranceDTO> validerContrat(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(contratService.validerContrat(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/resilier")
    public ResponseEntity<ContratAssuranceDTO> resilierContrat(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(contratService.resilierContrat(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
