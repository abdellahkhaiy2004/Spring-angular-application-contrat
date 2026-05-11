package com.example.project_exam.repositories;

import com.example.project_exam.entities.ContratAssurance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContratAssuranceRepository extends JpaRepository<ContratAssurance, Long> {
    List<ContratAssurance> findByClientId(Long clientId);
}
