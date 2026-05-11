package com.example.project_exam.web;

import com.example.project_exam.dtos.PaiementDTO;
import com.example.project_exam.services.PaiementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@AllArgsConstructor
public class PaiementRestController {

    private PaiementService paiementService;

    @GetMapping("/contrat/{contratId}")
    public List<PaiementDTO> getPaiementsByContrat(@PathVariable Long contratId) {
        return paiementService.getPaiementsByContratId(contratId);
    }

    @PostMapping
    public ResponseEntity<PaiementDTO> savePaiement(@RequestBody PaiementDTO paiementDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paiementService.savePaiement(paiementDTO));
    }
}
